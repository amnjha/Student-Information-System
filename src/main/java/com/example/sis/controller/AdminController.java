package com.example.sis.controller;

import com.example.sis.data.Admin;
import com.example.sis.data.Student;
import com.example.sis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdminController extends MVCController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private MarksService marksService;
    @Autowired
    private StudentService studentService;

    @PostMapping
    public String updateProfile(ModelMap model, String emailId, String name, String description) {
        Admin admin = adminService.updateProfile(emailId, name, description);

        model.put("email", emailId);
        model.put("name", admin.getName());
        model.put("designation", admin.getDesignation());
        model.put("description", admin.getDescription());

        return "user-admin";
    }

    @RequestMapping(value = "/attendance-admin", method = RequestMethod.POST)
    public String saveAttendance(HttpServletRequest request, ModelMap modelMap, @RequestParam String roll, @RequestParam String subject, @RequestParam("date") String dateString, @RequestParam String present) throws ParseException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = dateFormat.parse(dateString);
            Date currentDate = new Date();
            if(date.getTime()>currentDate.getTime()){
                modelMap.put("message", "Date Cannot be in future");
            }else {
                try {
                    attendanceService.saveAttendance(roll, date, "y".equalsIgnoreCase(present), subject);
                    modelMap.put("message", "Attendance Saved Successfully");
                } catch (NullPointerException e) {
                    modelMap.put("message", "Incorrect roll number, Please try again!");
                } catch (Exception e) {
                    modelMap.put("message", "Error Occurred While Saving Student Attendance");
                }
            }
            modelMap.put("subjects", subjectService.getAllSubjects());
            String adminEmail = (String) request.getSession(false).getAttribute("email");
            addAdminToModel(modelMap, adminEmail);
        }
        return "attendance-admin";
    }

    @RequestMapping(value = "/attendance-admin", method = RequestMethod.GET)
    public String showAdminAttendancePage(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("subjects", subjectService.getAllSubjects());

        String adminEmail = (String) request.getSession(false).getAttribute("email");
        addAdminToModel(modelMap, adminEmail);
        modelMap.remove("message");
        return "attendance-admin";
    }

    @RequestMapping(value = "/marks-admin", method = RequestMethod.POST)
    public String saveMarks(HttpServletRequest request, ModelMap modelMap, @RequestParam String internal, @RequestParam String mark, @RequestParam String subject, @RequestParam String roll) throws ParseException {
        HttpSession session = request.getSession();
        if (session != null) {
            try {
                marksService.savemarks(internal, mark, subject, roll);
                modelMap.put("message", "Marks Saved Successfully");
                modelMap.put("message", "Marks Saved Successfully");
            }catch (NullPointerException e){
                modelMap.put("message", "Incorrect roll number, Please try again!");
            }catch (Exception e){
                modelMap.put("message", "Error Occurred While Saving Student Marks");
            }
            modelMap.put("subjects", subjectService.getAllSubjects());
            String adminEmail = (String) request.getSession(false).getAttribute("email");
            addAdminToModel(modelMap, adminEmail);
        }


        return "marks-admin";

    }

    @RequestMapping(value = "/marks-admin", method = RequestMethod.GET)
    public String showMarksAdminPage(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("subjects", subjectService.getAllSubjects());
        String adminEmail = (String) request.getSession(false).getAttribute("email");
        addAdminToModel(modelMap, adminEmail);
        modelMap.remove("message");
        return "marks-admin";
    }

    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
    public String saveStudent(HttpServletRequest request, ModelMap modelMap, String email, String roll, String name, String branch, String section, String semester) throws ParseException {
        HttpSession session = request.getSession();
        if (session != null) {
            try{
                studentService.saveStudent(email,name,roll,branch,semester,section);
                modelMap.put("message", "Student Saved Successfully");
            }catch (Exception e){
                modelMap.put("message", "Error Occurred While Saving Student Details");
            }
            String adminEmail = (String) request.getSession(false).getAttribute("email");
            addAdminToModel(modelMap, adminEmail);
        }
        return "add-student";

    }

    @RequestMapping(value = "/add-student", method = RequestMethod.GET)
    public String showAddStudentPage(HttpServletRequest request, ModelMap modelMap) {
        String email = (String) request.getSession(false).getAttribute("email");
        addAdminToModel(modelMap, email);
        modelMap.remove("message");
        return "add-student";
    }

    private void addAdminToModel(ModelMap modelMap, String email){
        Admin admin = adminService.getAdmin(email);
        modelMap.put("designation", admin.getDesignation());
        modelMap.put("name", admin.getName());
    }

}
