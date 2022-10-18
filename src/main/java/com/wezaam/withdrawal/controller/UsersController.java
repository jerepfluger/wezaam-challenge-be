package com.wezaam.withdrawal.controller;

import com.wezaam.withdrawal.exception.DataBaseException;
import com.wezaam.withdrawal.exception.NotFoundException;
import com.wezaam.withdrawal.model.User;
import com.wezaam.withdrawal.service.UsersService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api
@RestController
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    // TODO: This could be a javax.Inject
    @Autowired
    private UsersService usersService;

    @GetMapping("/find-all-users")
    public List<User> findAll() throws DataBaseException {
        logger.info("Finding all users");
        return usersService.findAllUsers();
    }

    @GetMapping("/find-user-by-id/{id}")
    public User findById(@PathVariable Long id) throws Exception {
        logger.info("Finding user with id %d".formatted(id));
        Optional<User> user = usersService.findUserById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User %d not found in database".formatted(id));
        }

        return user.get();
    }
}
