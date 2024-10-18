package com.penny.springass1.dto;

import com.penny.springass1.entity.Address;
import com.penny.springass1.entity.Company;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data // auto initialize  setter and getter
public class AccountDTO {

    private Long id;

    @NotNull
    private String username;

    @Pattern(regexp = "^.{10}$", message = "The string must be exactly 10 characters long")
    private String phoneNumber;

    @Email
    private String email;

}

// 显式getter 和 setter
///Getter and setter for id
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
