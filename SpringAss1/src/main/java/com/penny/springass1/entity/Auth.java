package com.penny.springass1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auth {
    @Id
    @Column(unique = true, nullable = false)
    private String email;
    @Column
    private String password;
}
