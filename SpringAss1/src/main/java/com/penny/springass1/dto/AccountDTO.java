package com.penny.springass1.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data // auto initialize  setter and getter
public class AccountDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotBlank
    @Pattern(regexp = "^.{10}$", message = "The string must be exactly 10 characters long")
    private String phoneNumber;

    @Email
    private String email;
 // 复杂类需要有自己的dto！
}
