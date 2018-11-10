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

    public Student findUserByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public Student updateStudent(String email, String roll, String name, String description){
        Student student = studentRepository.findByEmail(email);
        student.setEmail(email);
        student.setDescription(description);
        student.setRoll(roll);
        student.setName(name);
        return studentRepository.save(student);
    }
}
