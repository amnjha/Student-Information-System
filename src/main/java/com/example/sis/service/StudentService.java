package com.example.sis.service;

import com.example.sis.data.Credentials;
import com.example.sis.data.Student;
import com.example.sis.repository.CredentialRepository;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    public Student findUserByRollNumber(String roll){
        Student student = studentRepository.findByRoll(roll);
        return student;
    }

    public Student findUserByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public Student updateStudent(String email, String roll, String name, String description){
        Student student = studentRepository.findByEmail(email);
        student.setDescription(description);
        student.setName(name);
        return studentRepository.save(student);
    }

    public Student saveStudent(String email, String name, String roll, String branch, String semester, String section){
        Student student = new Student();
        student.setUserName(email);
        student.setName(name);
        student.setEmail(email);
        student.setRoll(roll);
        student.setBranch(branch);
        student.setSection(section);
        student.setSemester(semester);

        Credentials credentials = new Credentials();
        credentials.setPassword("xyz");
        credentials.setUserName(email);
        credentials.setUserType(Credentials.UserType.STUDENT);
        credentialRepository.save(credentials);

        return studentRepository.save(student);
    }
}
