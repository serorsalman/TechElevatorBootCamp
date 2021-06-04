package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.User;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @ApiOperation("Returns a list of all of the users")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list() {
        return userDAO.findAll();
    }

    @ApiOperation("Returns the information of the currently authenticated user")
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public User get(Principal principal) {
        return userDAO.findByUsername(principal.getName());
    }

}
