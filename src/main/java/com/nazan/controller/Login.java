package com.nazan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by nazan on 12.01.2017.
 */

@RestController
public class Login {
    private final Logger log = LoggerFactory.getLogger(Login.class);

    @RequestMapping("/user")
    public Principal user(Principal user) {
        log.info("Logged in user-----------------------------------" + user.getName());
        return user;
    }
}
