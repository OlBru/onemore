package com.example.onemore.Controllers;


import com.example.onemore.Repositories.AccountRepository;
import com.example.onemore.Services.AccountService;
import com.example.onemore.models.holder;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.account;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/account")
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

    @GetMapping("/delete_account")
    public ModelAndView delete(@PathParam(value="id") Integer id) {
        if (id != null){
            accountService.deleteAccount(id);
            return new ModelAndView("account_list").addObject("delete_account", accountService.getAllAccounts());
        }
        return new ModelAndView("delete_account");
    }
    @GetMapping("/add_account")
    public ModelAndView setAll(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "holder") holder holder,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "registrationnumber") Integer registrationnumber) {
        if (id != null){
            account account = new account();
            account.setId(id);
            account.setHolder(holder);
            account.setType(type);
            account.setRegistrationnumber(registrationnumber);
            accountService.addAccount(account);
            return new ModelAndView("account_list").addObject("accounts", accountService.getAllAccounts());
        }
        return new ModelAndView("add_account");
    }

    @GetMapping("/show_account")
    public ModelAndView showAllAccounts(Model model) {
        List<account> accounts = accountService.getAllAccounts();
        return new ModelAndView("account_list").addObject("accounts", accounts);
    }

}



