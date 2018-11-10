package com.example.sis.controller;

import com.example.sis.data.Student;
import com.example.sis.repository.StudentRepository;
import com.example.sis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class HomeController extends MVCController {

    @Autowired
    private LoginService service;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Student student = studentRepository.findByEmail(email);
            model.put("email", email);
            model.put("name", student.getName());
            model.put("semester", student.getSemester());
            model.put("roll", student.getRoll());
            model.put("branch",student.getBranch());
            return "dashboard";
        }
        return "login";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String showWelcomePage(HttpServletRequest request, ModelMap model, @RequestParam String email, @RequestParam String password){

        Student student = service.validateUser(email, password);
        boolean isValidUser = student!=null;

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        else{
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(20*60); // Session Timeout in seconds, 20 minutes here
            session.setAttribute("email", email);
        }

        model.put("email", email);
        model.put("name", student.getName());
        model.put("semester", student.getSemester());
        model.put("roll", student.getRoll());
        model.put("branch",student.getBranch());
        return "dashboard";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfilePage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            populateModelMap(request, model);
            return "user";
        }
        return "login";
    }

    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public String showMarksPage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            populateModelMap(request, model);
            return "marks";
        }
        return "login";
    }

    private void populateModelMap(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Student student = studentRepository.findByEmail(email);
            model.put("email", email);
            model.put("name", student.getName());
            model.put("semester", student.getSemester());
            model.put("roll", student.getRoll());
            model.put("branch",student.getBranch());
            model.put("description", student.getDescription());
        }
    }
}