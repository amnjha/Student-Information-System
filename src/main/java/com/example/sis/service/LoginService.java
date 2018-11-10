package com.example.sis.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String email, String password) {
        // in28minutes, dummy
        return email.equalsIgnoreCase("aman.jha@ex.com")
                && password.equalsIgnoreCase("dummy");
    }

}