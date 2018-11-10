package com.example.sis.repository;

import com.example.sis.data.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
    public Student findByEmail(String email);
    public Student findAllBySemester(String semester);
    public Student findByRoll(String roll);
}
