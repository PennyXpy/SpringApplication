package com.penny.springass1.repository;

import com.penny.springass1.entity.Auth;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, String> {
}
