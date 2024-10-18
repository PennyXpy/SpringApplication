package com.penny.springass1.mapper;

import com.penny.springass1.dto.AuthDTO;
import com.penny.springass1.entity.Auth;
import org.springframework.stereotype.Component;


@Component
public class AuthMapper {
    public Auth toAuth(AuthDTO authDTO) {
        Auth newAuth = new Auth();
        newAuth.setEmail(authDTO.getEmail());
        newAuth.setPassword(authDTO.getPassword());
        return newAuth;
    }
}
