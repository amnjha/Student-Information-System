package com.example.sis.repository;

import com.example.sis.data.Marks;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarksRepository extends PagingAndSortingRepository<Marks, String> {
    public Marks findAllByUserNameAndExam(String userName, String exam);
    public Marks findAllByExam(String exam);
}
