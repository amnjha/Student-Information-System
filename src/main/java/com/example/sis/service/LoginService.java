package com.example.sis.service;

import com.example.sis.data.Admin;
import com.example.sis.data.Credentials;
import com.example.sis.data.Student;
import com.example.sis.data.User;
import com.example.sis.repository.CredentialRepository;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private StudentRepository studentRepository;

    public User validateUser(String email, String password) {
        Credentials credentials = credentialRepository.findByUserName(email);
        boolean validation=  credentials!=null && email.equalsIgnoreCase(credentials.getUserName()) && password.equals(credentials.getPassword());
        if(validation) {
            Credentials.UserType userType = credentials.getUserType();
            if(Credentials.UserType.ADMIN.equals(userType)){
                Admin admin = new Admin();
                return admin;
            }
            Student student = studentRepository.findByEmail(email);
            return student;
        }
        return null;
    }
}