package com.penny.springass1.entity;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {
    private Long id;
    @NotEmpty
    private String name;
    @NotBlank
    @Size(min = 10, max = 20, message = "Username length doesn't meet requirement")
    private String username;
    @Email
    private String email;
    @NotNull
    private Address address;
    @NotNull
    private String phone;
    private String website;
    private Company company;
}
// DTO -- data transfer object