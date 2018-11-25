package com.example.sis.service;

import com.example.sis.data.Attendance;
import com.example.sis.data.Student;
import com.example.sis.repository.AttendanceRepository;
import com.example.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Map<String, Object> getAttendancePercentage(String email){
        Map<String, Double> result = getAttendancePerSubject(email);
        Map<String, Object> attendanceMap = new HashMap<>();

        String key ="subject";
        int i=1;
        for (Map.Entry<String, Double> entry : result.entrySet()){
            attendanceMap.put(key+i, entry.getKey());
            attendanceMap.put(key+i+"_att", entry.getValue());
            i++;
        }
        return attendanceMap;
    }

    public Map<String, Double> getAttendancePerSubject(String email){
        Map<String, Double> result = new HashMap<>();

        Map<String, Integer> presentCount= new HashMap<>();
        Map<String, Integer> totalCount= new HashMap<>();
        Student student = studentRepository.findByEmail(email);
        List<Attendance> attendanceList =attendanceRepository.findAllBySemesterAndRoll(student.getSemester(), student.getRoll());
        for(Attendance attendance : attendanceList) {
            String subject = attendance.getSubject();
            if (totalCount.get(subject) == null){
                totalCount.put(subject, 1);
                presentCount.put(subject, 0);
            }
            else{
                totalCount.put(subject, totalCount.get(subject)+1);
            }

            if(attendance.isPresent()){
                presentCount.put(subject, presentCount.get(subject)+1);
            }
        }

        for(Map.Entry<String, Integer> entry : totalCount.entrySet()){
            try {
                Double per =  Math.round((presentCount.get(entry.getKey()) * 100.0D / entry.getValue())*100.0)/100.0;
                result.put(entry.getKey(),per);
            } catch (Exception e){
                result.put(entry.getKey(),0D);
            }
        }
        return result;
    }

    public double getTotalAttendancePercent(String email){
        Map<String, Double> result = getAttendancePerSubject(email);
        double total = 0;
        int count = 0;
        for (Map.Entry<String, Double> entry : result.entrySet()){
            count++;
            total+=entry.getValue();
        }
        return Math.round(total*100.0D/count)/100.0;
    }

    public Attendance saveAttendance(String roll, Date date, boolean present, String subject){
        Attendance attendance = new Attendance();
        Student student = studentRepository.findByRoll(roll);

        attendance.setPresent(present);
        attendance.setAttendanceId(UUID.randomUUID().toString());
        attendance.setSemester(student.getSemester());
        attendance.setDate(date);
        attendance.setSubject(subject);
        attendance.setRoll(roll);

        return attendanceRepository.save(attendance);
    }
}
