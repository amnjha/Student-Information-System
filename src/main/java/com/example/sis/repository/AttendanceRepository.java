package com.example.sis.repository;

import com.example.sis.data.Attendance;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AttendanceRepository extends PagingAndSortingRepository<Attendance, String> {
    public List<Attendance> findAllBySemesterAndRollAndPresent(String semester, String roll, boolean present);
    public List<Attendance> findAllBySemesterAndRoll(String semester, String roll);
}
