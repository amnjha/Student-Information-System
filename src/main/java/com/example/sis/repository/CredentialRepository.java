package com.example.sis.repository;

import com.example.sis.data.Credentials;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CredentialRepository extends PagingAndSortingRepository<String, Credentials> {
    
}
