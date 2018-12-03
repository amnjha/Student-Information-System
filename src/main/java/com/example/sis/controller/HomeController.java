package com.example.sis.controller;

import com.example.sis.data.Admin;
import com.example.sis.data.Attendance;
import com.example.sis.data.Student;
import com.example.sis.data.User;
import com.example.sis.repository.StudentRepository;
import com.example.sis.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Student student = studentService.findUserByEmail(email);
            if(student!=null) {
                model.put("attendance", attendanceService.getTotalAttendancePercent(email));
                model.put("email", email);
                model.put("name", student.getName());
                model.put("semester", student.getSemester());
                model.put("roll", student.getRoll());
                model.put("branch",student.getBranch());
                return "dashboard";
            }
            else{
                Admin admin = adminService.getAdmin(email);
                model.put("name", admin.getName());
                model.put("designation",admin.getDesignation());
                return "dashboard-admin";
            }
        }
        return "login";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String showWelcomePage(HttpServletRequest request, ModelMap model, @RequestParam String email, @RequestParam String password){

        User user = service.validateUser(email, password);
        boolean isValidUser = user!=null;

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
        if(user instanceof Student) {
            Student student = (Student) user;
            model.put("attendance", attendanceService.getTotalAttendancePercent(email));
            model.put("name", student.getName());
            model.put("semester", student.getSemester());
            model.put("roll", student.getRoll());
            model.put("branch", student.getBranch());
        }
        else{
            Admin admin = adminService.getAdmin(email);
            model.put("name", admin.getName());
            model.put("designation",admin.getDesignation());
            return "dashboard-admin";
        }
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

    @RequestMapping(value = "/profile-admin", method = RequestMethod.GET)
    public String showProfilePageAdmnin(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            boolean isAdmin = populateModelMapForAdmin(request, model);
            if(!isAdmin)
                return "login";
            return "user-admin";
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

    private boolean populateModelMapForAdmin(HttpServletRequest request, ModelMap model){
        HttpSession session = request.getSession(false);
        if(session!=null){
            String email = (String) session.getAttribute("email");
            Admin admin = adminService.getAdmin(email);
            if(admin==null)
                return false;
            model.put("email", email);
            model.put("name", admin.getName());
            model.put("designation", admin.getDesignation());
            model.put("description", admin.getDescription());
        }
        return true;
    }
}