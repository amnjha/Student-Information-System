package com.example.sis.service;

import com.example.sis.data.Marks;
import com.example.sis.data.Student;
import com.example.sis.repository.MarksRepository;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Map<String, String> getAllMarks(String email) {
        Student student = studentRepository.findByEmail(email);
        String sem = student.getSemester();

        String examName = sem.charAt(0) + "_INT_" + 1;
        List<Marks> marks = marksRepository.findAllByUserNameAndExam(email, examName);

        Map<String, String> markMap = new HashMap<>();
        String subjectKey = "t1_subject";
        int i = 1;
        for (Marks mark : marks) {
            markMap.put(subjectKey + i, mark.getSubject());
            markMap.put(subjectKey + i + "_marks", mark.getMarks());
            i++;
        }

        examName = sem.charAt(0) + "_INT_" + 2;
        marks = marksRepository.findAllByUserNameAndExam(email, examName);

        subjectKey = "t2_subject";
        i = 1;
        for (Marks mark : marks) {
            markMap.put(subjectKey + i, mark.getSubject());
            markMap.put(subjectKey + i + "_marks", mark.getMarks());
            i++;
        }

        return markMap;
    }

    public Marks savemarks(String internal, String marks, String subject, String roll) {
        Marks mark = new Marks();
        Student student = studentRepository.findByRoll(roll);

        mark.setMarksId(UUID.randomUUID().toString());
        mark.setExam(student.getSemester() + "_INT_" + internal);
        mark.setMarks(marks);
        mark.setSubject(subject);
        mark.setUserName(student.getUserName());

        return marksRepository.save(mark);

    }
}
