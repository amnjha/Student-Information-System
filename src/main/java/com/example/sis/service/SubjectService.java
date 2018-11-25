package com.example.sis.service;

import com.example.sis.data.Subject;
import com.example.sis.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<String> getAllSubjects(){
        Iterable<Subject> subjects = subjectRepository.findAll();
        List<String> result = new ArrayList<>();
        for(Subject subject : subjects){
            result.add(subject.getSubjectName());
        }
        return result;
    }
}
