package com.example.onemore.Controllers;


import com.example.onemore.Repositories.AccountRepository;
import com.example.onemore.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.account;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

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

    @GetMapping("/show")
    public String showAllAccounts(Model model) {
        List<account> accounts = accountService.getAllAccounts();
        model.addAttribute("account", accounts);
        return "account_list"; // Имя представления (шаблона Thymeleaf)
    }

}



