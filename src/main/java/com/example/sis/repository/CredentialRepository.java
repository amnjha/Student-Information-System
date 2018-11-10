package com.example.sis.repository;

import com.example.sis.data.Credentials;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends PagingAndSortingRepository<Credentials, String> {

    public Credentials findByUserName(String email);
}
