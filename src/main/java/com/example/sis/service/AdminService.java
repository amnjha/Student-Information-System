package com.example.sis.service;

import com.example.sis.data.Admin;
import com.example.sis.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    public AdminRepository adminRepository;

    public Admin getAdmin(String email){
        return adminRepository.findByEmail(email);
    }

    public Admin updateProfile(String email, String name, String description){
        Admin admin = adminRepository.findByEmail(email);
        admin.setName(name);
        admin.setDescription(description);
        return adminRepository.save(admin);
    }
}
