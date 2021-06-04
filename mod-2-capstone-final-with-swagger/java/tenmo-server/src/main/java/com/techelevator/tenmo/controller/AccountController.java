package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Transfer;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDAO accountDAO;
    private UserDAO userDAO;
    private TransferDAO transferDAO;

    public AccountController(AccountDAO accountDAO, UserDAO userDAO, TransferDAO transferDAO) {
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
        this.transferDAO = transferDAO;
    }

    @ApiOperation("Returns the balance of the currently authenticated user")
    @RequestMapping( value = "/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(@ApiIgnore Principal principal) throws UsernameNotFoundException {
        Long userId = getCurrentUserId(principal);
        return accountDAO.getAccountByUserId(userId).getBalance();
    }

    @ApiOperation("Returns all of the transfers sent and received by the currently authenticated user")
    @RequestMapping(value = "/transfers", method = RequestMethod.GET)
    public List<Transfer> getTransfers(@ApiIgnore Principal principal) {
        return transferDAO.getTransfersForUser(getCurrentUserId(principal));
    }

    /**
     * Finds the user by username and returns the id
     * @param principal the current authenticated user
     * @return Long user_id
     */
    private Long getCurrentUserId(Principal principal) {
        return userDAO.findByUsername(principal.getName()).getId();
    }
}
