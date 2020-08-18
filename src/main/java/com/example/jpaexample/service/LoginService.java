package com.example.jpaexample.service;

import com.example.jpaexample.entity.User;
import com.example.jpaexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public boolean validateLogin(String userName, String password) {
        User user = repository.findByUserName(userName);

        if (user == null) {
            return false;
        } else {
            return user.getPassword().equals(password);
        }
    }
}
