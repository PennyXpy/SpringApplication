package com.penny.springass1.repository;


import com.penny.springass1.entity.Account;
import com.sun.jdi.InterfaceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}