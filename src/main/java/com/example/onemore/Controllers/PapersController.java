package com.example.onemore.Controllers;

import com.example.onemore.Repositories.IssuerRepository;
import com.example.onemore.Repositories.PapersRepository;
import com.example.onemore.Services.PapersService;
import com.example.onemore.models.account;
import com.example.onemore.models.holder;
import com.example.onemore.models.issuer;
import com.example.onemore.models.papers;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PapersController {
    private final PapersService papersService;
    private final IssuerRepository issuerRepository;

    @Autowired
    public PapersController(PapersService paperService, IssuerRepository issuerRepository) {
        this.papersService = paperService;
        this.issuerRepository = issuerRepository;
    }

    @GetMapping("/getallpapers")
    public List<papers> getAllPapers() {
        return papersService.getAllPapers();
    }

    @GetMapping("/getpaper{id}")
    public papers getPaper(@PathVariable Integer id) {
        return papersService.getPaper(id);
    }

    @PostMapping("/createpapers")
    public void createPaper(@RequestBody papers paper) {
        papersService.addPaper(paper);
    }

    @PutMapping("/updatepaper")
    public void updatePaper(@RequestBody papers paper) {
        papersService.updatePaper(paper);
    }

    @DeleteMapping("/deletepaper{id}")
    public void deletePaper(@PathVariable Integer id) {
        papersService.deletePaper(id);
    }

    @GetMapping("/delete_papers")
    public ModelAndView delete(@PathParam(value = "id") Integer id) {
        if (id != null) {
            papersService.deletePaper(id);
            return new ModelAndView("papers_list").addObject("delete_papers", papersService.getAllPapers());
        }
        return new ModelAndView("delete_papers");
    }

    @GetMapping("/add_papers")
    public ModelAndView setAll(@PathParam(value = "IDofPapers") Integer IDofPapers,
                               @PathParam(value = "IdofIssuer") Integer IDofIssuer,
                               @PathParam(value = "Type") String Type,
                               @PathParam(value = "Nominal") Integer Nominal,
                               @PathParam(value = "ReleaseDate") Date ReleaseDate,
                               @PathParam(value = "Capital") String Capital,
                               @PathParam(value = "IssueForm") String IssueForm,
                               @PathParam(value = "IDofParent") Integer IDofParent) {
        if (IDofPapers != null) {
            papers papers = new papers();
            papers.setIDofPapers(IDofPapers);
/*
            var issuers = new ArrayList<issuer>();
            issuerRepository.findAll().forEach(issuer -> {
                issuers.add(issuer);
            });

            var currentIssuer = issuers.stream()
                    .filter(holder -> holder.getIDofIssuer().equals(IdofIssuer))
                    .findAny()
                    .orElse(null);


            papers.setIDofIssuer(currentIssuer);
            papers.setIDofIssuer(IdofIssuer);*/
            papers.setIDofIssuer(IDofIssuer);
            papers.setType(Type);
            papers.setNominal(Nominal);
            papers.setReleaseDate(ReleaseDate);
            papers.setCapital(Capital);
            papers.setIssueForm(IssueForm);
            papers.setIDofParent(IDofParent);
            papersService.addPaper(papers);
            return new ModelAndView("papers_list").addObject("paperss", papersService.getAllPapers());
        }
        return new ModelAndView("add_papers");
    }

    @GetMapping("/show_papers")
    public ModelAndView showAllPapers(Model model) {
        List<papers> paperss = papersService.getAllPapers();
        return new ModelAndView("papers_list").addObject("paperss", paperss);
    }
}
