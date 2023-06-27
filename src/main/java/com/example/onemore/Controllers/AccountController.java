package com.example.onemore.Controllers;


import com.example.onemore.Repositories.AccountRepository;
import com.example.onemore.Repositories.HolderRepository;
import com.example.onemore.Services.AccountService;
import com.example.onemore.models.holder;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.account;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    private final HolderRepository holderRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Autowired
    public AccountController(HolderRepository holderRepository, AccountService accountService, AccountRepository accountRepository) {
        this.holderRepository = holderRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/getallaccount")
    public List<account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/getaccount{id}")
    public account getAccount(@PathVariable Integer id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/createaccount")
    public void createAccount(@RequestBody account account) {
        accountService.updateAccount(account);
    }

    @PutMapping("/updateaccount")
    public void updateAccount(@RequestBody account account) {
        accountService.updateAccount(account);
    }

    @DeleteMapping("/deleteaccount{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }

    @GetMapping("/delete_account")
    public ModelAndView delete(@PathParam(value = "id") Integer id) {
        if (id != null) {
            accountService.deleteAccount(id);
            return new ModelAndView("account_list").addObject("delete_account", accountService.getAllAccounts());
        }
        return new ModelAndView("delete_account");
    }

    @GetMapping("/add_account")
    public ModelAndView setAll(@PathParam(value = "id") Integer id,
                               @PathParam(value = "holder") holder holderId,
                               @PathParam(value = "type") String type,
                               @PathParam(value = "registrationnumber") Integer registrationnumber) {
        if (id != null) {
            account account = new account();
            account.setId(id);

            var holders = new ArrayList<holder>();
            holderRepository.findAll().forEach(holder -> {
                holders.add(holder);
            });

            var currentHolder = holders.stream()
                    .filter(holder -> holder.getIDofHolder().equals(holderId))
                    .findAny()
                    .orElse(null);


            account.setHolder(currentHolder);
            account.setHolder(holderId);
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



