package com.penny.springass1.service;


import com.penny.springass1.entity.Account;
import com.penny.springass1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }

    public Account createNewAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccountById(Long id, Account account){
        if (accountRepository.findById(id).isEmpty()){
            throw new RuntimeException("id not found");
        }
        account.setId(id);
        return accountRepository.save(account);
    }

    public boolean deleteAccountById(Long id) {
        accountRepository.deleteById(id);
        return true;
    }

    public List<Account> createAccounts(List<Account> list) {
        return accountRepository.saveAll(list);
    }
}