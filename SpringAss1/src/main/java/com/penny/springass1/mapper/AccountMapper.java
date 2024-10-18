package com.penny.springass1.mapper;

import com.penny.springass1.dto.AccountDTO;
import com.penny.springass1.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toAccount(AccountDTO accountDTO) {
        Account newAccount = new Account();
        newAccount.setId(accountDTO.getId());
        return newAccount;
    }

}
