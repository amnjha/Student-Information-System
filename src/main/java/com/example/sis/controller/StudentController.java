package com.example.sis.controller;

import com.example.sis.data.RestResponse;
import com.example.sis.data.Student;
import com.example.sis.service.MarksService;
import com.example.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController extends MVCController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarksService marksService;

    @GetMapping
    public RestResponse getStudent(@RequestParam String roll) {
        Student student = studentService.findUserByRollNumber(roll);
        return RestResponse.buildRestResponse(200, student, "Success");
    }

    @PostMapping
    public String updateProfile(HttpServletRequest request, ModelMap model, String emailId, String roll, String name, String description) {
         Student student = studentService.updateStudent(emailId, roll, name, description);

        model.put("email", emailId);
        model.put("name", student.getName());
        model.put("semester", student.getSemester());
        model.put("roll", student.getRoll());
        model.put("branch", student.getBranch());
        model.put("description", student.getDescription());

        return "user";
    }

    @GetMapping("/marks")
    public RestResponse getMarks(HttpServletRequest request){
        String email = (String) request.getSession(false).getAttribute("email");
        marksService.getAllMarks(email);
        return null;
    }
}
