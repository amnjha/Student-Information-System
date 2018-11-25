package com.example.sis.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
    @Id
    private String attendanceId;
    private String subjectName;
    private String semester;

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
