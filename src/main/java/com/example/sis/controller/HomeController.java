package com.example.sis.controller;

import com.example.sis.data.Student;
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

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
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
        return "dashboard";
    }

}