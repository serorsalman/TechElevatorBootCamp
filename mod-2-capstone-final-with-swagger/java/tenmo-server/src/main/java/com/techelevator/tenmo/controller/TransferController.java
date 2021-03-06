package com.techelevator.tenmo.controller;

import java.security.Principal;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthorizationException;
import com.techelevator.tenmo.model.NewTransferDTO;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferAuthorization;
import com.techelevator.tenmo.model.TransferStatusUpdateDTO;
import com.techelevator.tenmo.model.User;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/transfers")
@PreAuthorize("isAuthenticated()")
public class TransferController {

    private TransferDAO transferDAO;
    private AccountDAO accountDAO;
    private UserDAO userDAO;

    public TransferController(TransferDAO transferDAO, AccountDAO accountDAO, UserDAO userDAO) {
        this.transferDAO = transferDAO;
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
    }

    @ApiOperation("Returns the information of the given transfer ID if the transfer is associated with the currently authenticated user")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Transfer getTransfer(@PathVariable @ApiParam("ID of the transfer to return") Long id, @ApiIgnore Principal principal) {
        Transfer transfer = transferDAO.getTransferById(id);
        validateAuthorizationToView(principal, transfer);
        return transfer;
    }

    @ApiOperation("Transfers money from the currently authenticated user to the given user")
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Transfer createTransfer(@Valid @RequestBody @ApiParam("Transfer information") NewTransferDTO transferDTO, @ApiIgnore Principal principal) {
    	Transfer transfer = buildTransferFromTransferDTO(transferDTO);
    	validateAuthorizationToCreate(principal, transfer);
    	transfer = transferDAO.addTransfer(transfer);
    	if(transfer.isApproved()) {
    		transferBucksBetweenAccounts(transfer);
    	}
    	return transfer;
    }

    @ApiOperation("Updates the status of the given transfer ID")
    @RequestMapping(value = "/{transferId}", method = RequestMethod.PUT)
	public Transfer updateTransferStatus(@PathVariable @ApiParam("ID of the transfer to update") Long transferId, @Valid @RequestBody TransferStatusUpdateDTO dto, Principal principal) {
    	String newStatus = dto.getTransferStatus();
    	Transfer transfer = transferDAO.getTransferById(transferId);
    	validateAuthorizationToUpdateStatus(principal, transfer);
    	if(Transfer.TRANSFER_STATUS_APPROVED.equals(newStatus)) {
    		transfer.approve();
    		transferBucksBetweenAccounts(transfer);
    	} else if(Transfer.TRANSFER_STATUS_REJECTED.equals(newStatus)) {
    		transfer.reject();
    	} 
    	transferDAO.updateStatus(transfer);
		return transfer;
    }

	private Transfer buildTransferFromTransferDTO(NewTransferDTO transferDTO) {
		User userFrom = userDAO.getUserById(transferDTO.getUserFrom());
    	User userTo = userDAO.getUserById(transferDTO.getUserTo());
    	
    	return new Transfer(transferDTO.getTransferType(),
						    userFrom,
						    userTo,
						    transferDTO.getAmount());
	}

	private void transferBucksBetweenAccounts(Transfer transfer) {
		Account accountFrom = accountDAO.getAccountByUserId(transfer.getUserFrom().getId());
		Account accountTo = accountDAO.getAccountByUserId(transfer.getUserTo().getId());
		accountFrom.transfer(accountTo, transfer.getAmount());
		accountDAO.updateBalance(accountFrom);
		accountDAO.updateBalance(accountTo);
	}
	
	private void validateAuthorizationToView(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToView()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToCreate(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToUpdateStatus(Principal principal, Transfer transfer) {
		TransferAuthorization auth = new TransferAuthorization(principal, transfer);
        if(!auth.isAllowedToApproveOrReject()) {
        	throw new AuthorizationException();
        }
	}
}
