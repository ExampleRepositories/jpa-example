package com.example.jpaexample.controller;

import com.example.jpaexample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;

@Controller
//@RequestMapping("/")
@SessionAttributes("name")
public class UserController {

    @PostConstruct
    public void test() {
        System.out.println();
    }

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(ModelMap model, @RequestParam String name, @RequestParam String password) {

        if (loginService.validateLogin(name, password)) {

            return "welcome";
        } else {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
}
