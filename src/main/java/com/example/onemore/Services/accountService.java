package com.example.onemore.Services;


import com.example.onemore.Repositories.AccountRepository;
import com.example.onemore.models.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class accountService {
    private final AccountRepository accountRepository;

    @Autowired
    public accountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<account> getAllAccounts() {
        List<account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public account getAccount(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    public void addAccount(account account) {
        accountRepository.save(account);
    }

    public void updateAccount(account account) {
        accountRepository.save(account);
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}
