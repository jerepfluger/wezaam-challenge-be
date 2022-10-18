package com.wezaam.withdrawal.service;

import com.wezaam.withdrawal.exception.DataBaseException;
import com.wezaam.withdrawal.model.User;
import com.wezaam.withdrawal.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private UsersRepository usersRepository;

    public List<User> findAllUsers() throws DataBaseException {
        List<User> users;
        try {
            logger.info("Retrieving all database users");
            users = this.usersRepository.findAll();
        } catch (Exception ex) {
            logger.error("An exception occurred when looking for transaction in database. Exception: " + ex);
            throw new DataBaseException(ex);
        }

        return users;
    }

    public Optional<User> findUserById(Long id) throws DataBaseException{
        Optional<User> user;
        try {
            logger.info("Searching for user %d in database".formatted(id));
            user = this.usersRepository.findById(id);
        } catch (Exception ex) {
            logger.error("An exception occurred when looking for transaction in database. Exception: " + ex);
            throw new DataBaseException(ex);
        }

        return user;
    }
}
