package com.example.onemore.Controllers;


import com.example.onemore.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.account;

import java.util.List;
    @RestController
    @RequestMapping("/account")
    public class AccountController {
        private final AccountRepository accountRepository;
        private final com.example.onemore.Services.accountService accountService;

        @Autowired
        public AccountController(com.example.onemore.Services.accountService accountService, AccountRepository accountRepository) {
            this.accountService = accountService;
            this.accountRepository = accountRepository;
        }

        @GetMapping("/please")
        public String hello(){return "hello world";}

        @GetMapping("/getall")
        public List<account> getAllAccounts() {
            return accountService.getAllAccounts();
        }

        @GetMapping("/{id}")
        public account getAccount(@PathVariable Integer id) {
            return accountService.getAccount(id);
        }

        @PostMapping("")
        public void createAccount(@RequestBody account account) {
            accountService.updateAccount(account);
        }

        @PutMapping("")
        public void updateAccount(@RequestBody account account) {
            accountService.updateAccount(account);
        }

        @DeleteMapping("/{id}")
        public void deleteAccount(@PathVariable Integer id) {
            accountService.deleteAccount(id);
        }
    }

