package com.example.sis.controller;

import com.example.sis.data.Attendance;
import com.example.sis.data.Student;
import com.example.sis.repository.StudentRepository;
import com.example.sis.service.AttendanceService;
import com.example.sis.service.LoginService;
import com.example.sis.service.MarksService;
import com.example.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes("name")
public class HomeController extends MVCController {

    @Autowired
    private LoginService service;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Student student = studentService.findUserByEmail(email);
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

        model.put("attendance", attendanceService.getTotalAttendancePercent(email));
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
            String email = (String) request.getSession(false).getAttribute("email");
            Map<String, String> marks = marksService.getAllMarks(email);
            model.putAll(marks);
            return "marks";
        }
        return "login";
    }

    @RequestMapping(value = "/attendance", method = RequestMethod.GET)
    public String showAttendancePage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            populateModelMap(request, model);
            String email = (String) request.getSession(false).getAttribute("email");
            Map<String, Object> attendancePercentage = attendanceService.getAttendancePercentage(email);
            model.putAll(attendancePercentage);
            return "attendance";
        }
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "login";
    }

    private void populateModelMap(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Student student = studentService.findUserByEmail(email);
            model.put("email", email);
            model.put("name", student.getName());
            model.put("semester", student.getSemester());
            model.put("roll", student.getRoll());
            model.put("branch",student.getBranch());
            model.put("description", student.getDescription());
        }
    }
}