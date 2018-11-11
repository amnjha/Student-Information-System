package com.example.sis.repository;

import com.example.sis.data.Notice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface NoticeRepository extends PagingAndSortingRepository<Notice, String> {
    public List<Notice> findAllByNoticeDateAfter(Date date);
}
