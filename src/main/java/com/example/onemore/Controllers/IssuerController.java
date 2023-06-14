package com.example.onemore.Controllers;

import com.example.onemore.Repositories.IssuerRepository;
import com.example.onemore.Services.IssuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.issuer;

import java.util.List;

@RestController
@RequestMapping("/issuer")
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

    @GetMapping("/getall")
    public List<issuer> getAllIssuers() {
        return issuerService.getAllIssuers();
    }

    @GetMapping("/{id}")
    public issuer getIssuer(@PathVariable Integer id) {
        return issuerService.getIssuer(id);
    }

    @PostMapping("")
    public void createIssuer(@RequestBody issuer issuer) {
        issuerService.addIssuer(issuer);
    }

    @PutMapping("")
    public void updateIssuer(@RequestBody issuer issuer) {
        issuerService.updateIssuer(issuer);
    }

    @DeleteMapping("/{id}")
    public void deleteIssuer(@PathVariable Integer id) {
        issuerService.deleteIssuer(id);
    }
}
