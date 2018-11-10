package com.example.sis.service;

import com.example.sis.data.Credentials;
import com.example.sis.data.Student;
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

    public Student validateUser(String email, String password) {
        Credentials credentials = credentialRepository.findByUserName(email);
        boolean validation=  email.equalsIgnoreCase(credentials.getUserName()) && password.equals(credentials.getPassword());
        if(validation) {
            Student student = studentRepository.findByEmail(email);
            return student;
        }
        return null;
    }
}