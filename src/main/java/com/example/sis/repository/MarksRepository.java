package com.example.sis.repository;

import com.example.sis.data.Marks;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarksRepository extends PagingAndSortingRepository<String, Marks> {
    public Marks findAllByUsernameAndExam();
    public Marks findAllByExam();
}
