package com.example.sis.repository;

import com.example.sis.data.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin,String> {
    public Admin findByEmail(String email);

}
