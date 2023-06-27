package com.example.onemore.Controllers;

import com.example.onemore.Repositories.AccountRepository;
import com.example.onemore.Repositories.MediatorRepository;
import com.example.onemore.Repositories.PapersRepository;
import com.example.onemore.models.*;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.Services.BuysellService;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class BuysellController {
    private final BuysellService buysellService;
    private final AccountRepository accountRepository;
    private final PapersRepository papersRepository;
    private final MediatorRepository mediatorRepository;

    @Autowired
    public BuysellController(BuysellService buysellService, AccountRepository accountRepository, PapersRepository
            papersRepository, MediatorRepository mediatorRepository) {
        this.buysellService = buysellService;
        this.accountRepository = accountRepository;
        this.papersRepository = papersRepository;
        this.mediatorRepository = mediatorRepository;
    }

    @GetMapping("/getallbuysell")
    public List<buysell> getAllBuysell() {
        return buysellService.getAllBuysell();
    }

    @GetMapping("/getbuysell{id}")
    public buysell getBuysell(@PathVariable Integer id) {
        return buysellService.getBuysell(id);
    }

    @PostMapping("/addbuysell")
    public void addBuysell(@RequestBody buysell buysell) {
        buysellService.addBuysell(buysell);
    }

    @PutMapping("/updatebuysell")
    public void updateBuysell(@RequestBody buysell buysell) {
        buysellService.updateBuysell(buysell);
    }

    @DeleteMapping("/deletebuysell{id}")
    public void deleteBuysell(@PathVariable Integer id) {
        buysellService.deleteBuysell(id);
    }

    @GetMapping("/delete_buysell")
    public ModelAndView delete(@PathParam(value = "id") Integer id) {
        if (id != null) {
            buysellService.deleteBuysell(id);
            return new ModelAndView("buysell_list").addObject("delete_buysell", buysellService.getAllBuysell());
        }
        return new ModelAndView("delete_buysell");
    }
    @GetMapping("/add_buysell")
    public ModelAndView setAll(@PathParam(value = "id") Integer id,
                               @PathParam(value = "account") account accountId,
                               @PathParam(value = "date") Date date,
                               @PathParam(value = "Type") String Type,
                               @PathParam(value = "papers") papers paperId,
                               @PathParam(value = "mediator") mediator mediatorId) {
        if (id != null) {
            buysell buysell = new buysell();
            buysell.setId(id);

            var accounts = new ArrayList<account>();

            accountRepository.findAll().forEach(account -> {
                accounts.add(account);
            });

            var currentAccount = accounts.stream()
                    .filter(account -> account.getId().equals(accountId))
                    .findAny()
                    .orElse(null);


            buysell.setAccount(currentAccount);
            buysell.setAccount(accountId);

            var paperss = new ArrayList<papers>();

            papersRepository.findAll().forEach(papers -> {
                paperss.add(papers);
            });

            var currentPapers = paperss.stream()
                    .filter(papers -> papers.getIDofPapers().equals(paperId))
                    .findAny()
                    .orElse(null);


            buysell.setPapers(currentPapers);
            buysell.setPapers(paperId);

            var mediators = new ArrayList<mediator>();

            mediatorRepository.findAll().forEach(mediator -> {
                mediators.add(mediator);
            });

            var currentMediator = mediators.stream()
                    .filter(mediator -> mediator.getIDofMediator().equals(mediatorId))
                    .findAny()
                    .orElse(null);


            buysell.setMediator(currentMediator);
            buysell.setMediator(mediatorId);

            buysell.setType(Type);
            buysell.setDate(date);
            buysellService.addBuysell(buysell);
            return new ModelAndView("buysell_list").addObject("buysells", buysellService.getAllBuysell());
        }
        return new ModelAndView("add_buysell");
    }
    @GetMapping("/show_buysell")
    public ModelAndView showAllOperations(Model model) {
        List<buysell> buysells = buysellService.getAllBuysell();
        return new ModelAndView("buysell_list").addObject("buysells", buysells);
    }
}
