package com.penny.springass1.dto;

import com.penny.springass1.entity.Address;
import com.penny.springass1.entity.Company;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data // auto initialize  setter and getter
public class UserDTO {
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
    private Company company; // 复杂类需要有自己的dto！
}
