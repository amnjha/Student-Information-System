package com.example.sis.repository;

import com.example.sis.data.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject,String> {
    public List<Subject> findAllBySemester(String semester);
}
