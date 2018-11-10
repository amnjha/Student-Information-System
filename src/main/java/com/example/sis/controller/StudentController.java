package com.example.sis.controller;

import com.example.sis.data.RestResponse;
import com.example.sis.data.Student;
import com.example.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController extends MVCController{

    @Autowired
    private StudentService studentService;

    @GetMapping
    public RestResponse getStudent(@RequestParam String roll){
        Student student= studentService.findUserByRollNumber(roll);
        return RestResponse.buildRestResponse(200, student, "Success");
    }
}
