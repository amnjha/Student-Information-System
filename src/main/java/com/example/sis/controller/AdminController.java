package com.example.sis.controller;

import com.example.sis.data.Admin;
import com.example.sis.service.AdminService;
import com.example.sis.service.AttendanceService;
import com.example.sis.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdminController extends  MVCController{

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/attendance-admin", method = RequestMethod.POST)
    public String saveAttendance(HttpServletRequest request, ModelMap modelMap, @RequestParam String roll , @RequestParam String subject, @RequestParam("date") String dateString, @RequestParam String present) throws ParseException {
        HttpSession session = request.getSession(false);
        if(session!=null){
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(dateString);

            attendanceService.saveAttendance(roll, date, "y".equalsIgnoreCase(present), subject);
            modelMap.put("message", "Attendance Saved Successfully");
            modelMap.put("subjects", subjectService.getAllSubjects());
            Admin admin =adminService.getAdmin((String) request.getSession(false).getAttribute("email"));
            modelMap.put("designation",admin.getDesignation());
            modelMap.put("name", admin.getName());
        }
        return "attendance-admin";
    }

    @RequestMapping(value = "/attendance-admin", method = RequestMethod.GET)
    public String showAdminAttendancePage(HttpServletRequest request, ModelMap modelMap){
        modelMap.put("subjects", subjectService.getAllSubjects());

        Admin admin =adminService.getAdmin((String) request.getSession(false).getAttribute("email"));
        modelMap.put("designation",admin.getDesignation());
        modelMap.put("name", admin.getName());
        modelMap.remove("message");
        return "attendance-admin";
    }


}
