package com.penny.springass1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthDTO {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
