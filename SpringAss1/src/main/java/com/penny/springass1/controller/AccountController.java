package com.penny.springass1.controller;


import com.penny.springass1.dto.AccountDTO;
import com.penny.springass1.entity.Account;
import com.penny.springass1.mapper.AccountMapper;
import com.penny.springass1.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id){
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity<Account> creatNewAccount(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for (FieldError error: bindingResult.getFieldErrors()){
                System.out.println(error.getField() + " ---" + error.getRejectedValue());
            }
            throw new RuntimeException("Bad Request");
        }
        return ResponseEntity.ok(accountService.createNewAccount(accountMapper.toAccount(accountDTO))); // !!!!!!
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<Account>> creatAccounts(@Valid @RequestBody List<AccountDTO> accountDTOs, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for (FieldError error: bindingResult.getFieldErrors()){
                System.out.println(error.getField() + " ---" + error.getRejectedValue());
            }
            throw new RuntimeException("Bad Request");
        }
        return ResponseEntity.ok(accountService.createAccounts(accountDTOs.stream().map(accountMapper::toAccount).toList())); // !!!!!!
    }


    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccountById(@PathVariable Long id, @RequestBody Account account){
        Account updatedAccount = accountService.updateAccountById(id, account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.deleteAccountById(id));
    }

}
