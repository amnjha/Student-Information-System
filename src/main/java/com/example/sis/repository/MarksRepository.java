package com.example.sis.repository;

import com.example.sis.data.Marks;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MarksRepository extends PagingAndSortingRepository<Marks, String> {
    public List<Marks> findAllByUserNameAndExam(String userName, String exam);
    public Marks findAllByExam(String exam);
}
