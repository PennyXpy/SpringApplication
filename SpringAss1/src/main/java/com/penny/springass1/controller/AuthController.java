package com.penny.springass1.controller;


import com.penny.springass1.dto.AuthDTO;
import com.penny.springass1.entity.Auth;
import com.penny.springass1.mapper.AuthMapper;
import com.penny.springass1.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;
    private final AuthMapper authMapper;

    @Autowired
    public AuthController(AuthService authService, AuthMapper authMapper) {
        this.authService = authService;
        this.authMapper = authMapper;
    }

    @PostMapping
    public ResponseEntity<Auth> signUp(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(authService.createNewAuth(authMapper.toAuth(authDTO)));
    }
}
