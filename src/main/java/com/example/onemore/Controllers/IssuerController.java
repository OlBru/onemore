package com.example.onemore.Controllers;

import com.example.onemore.Repositories.IssuerRepository;
import com.example.onemore.Services.IssuerService;
import com.example.onemore.models.holder;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.issuer;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class IssuerController {

    private final IssuerRepository issuerRepository;
    private final IssuerService issuerService;

    @Autowired
    public IssuerController(IssuerService issuerService, IssuerRepository issuerRepository) {
        this.issuerService = issuerService;
        this.issuerRepository = issuerRepository;
    }

    @GetMapping("/please")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/getallissuer")
    public List<issuer> getAllIssuers() {
        return issuerService.getAllIssuers();
    }

    @GetMapping("/getissuer{id}")
    public issuer getIssuer(@PathVariable Integer id) {
        return issuerService.getIssuer(id);
    }

    @PostMapping("/createissuer")
    public void createIssuer(@RequestBody issuer issuer) {
        issuerService.addIssuer(issuer);
    }

    @PutMapping("/updateissuer")
    public void updateIssuer(@RequestBody issuer issuer) {
        issuerService.updateIssuer(issuer);
    }

    @DeleteMapping("/deleteissuer{id}")
    public void deleteIssuer(@PathVariable Integer id) {
        issuerService.deleteIssuer(id);
    }

    @GetMapping("/delete_issuer")
    public ModelAndView delete(@PathParam(value = "id") Integer id) {
        if (id != null) {
            issuerService.deleteIssuer(id);
            return new ModelAndView("issuer_list").addObject("delete_issuer", issuerService.getAllIssuers());
        }
        return new ModelAndView("delete_issuer");
    }

    @GetMapping("/show_issuer")
    public ModelAndView showAllHolders(Model model) {
        List<issuer> issuers = issuerService.getAllIssuers();
        return new ModelAndView("issuer_list").addObject("issuers", issuers);}
}
