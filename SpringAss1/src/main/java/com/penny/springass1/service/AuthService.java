package com.penny.springass1.service;

import com.penny.springass1.entity.Auth;
import com.penny.springass1.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Auth getAuthById(String id) {
        return authRepository.findById(id).orElseThrow(() -> new RuntimeException("Email not find"));
    }

    public Auth creatNewAuth(Auth auth) {
        return authRepository.save(auth);
    }

    public Auth updateAuth(String id, Auth auth) {
        if (authRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Auth not found");
        }
        auth.setEmail(id);
        return authRepository.save(auth);
    }

}
