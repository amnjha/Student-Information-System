package com.example.sis.service;

import com.example.sis.data.Student;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findUserByRollNumber(String roll){
        Student student = studentRepository.findByRoll(roll);
        return student;
    }
}
