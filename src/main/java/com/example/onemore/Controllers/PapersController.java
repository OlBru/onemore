package com.example.onemore.Controllers;

import com.example.onemore.Services.PapersService;
import com.example.onemore.models.account;
import com.example.onemore.models.papers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/papers")
public class PapersController {
    private final PapersService papersService;

    @Autowired
    public PapersController(PapersService paperService) {
        this.papersService = paperService;
    }

    @GetMapping("/getall")
    public List<papers> getAllPapers() {
        return papersService.getAllPapers();
    }

    @GetMapping("/{id}")
    public papers getPaper(@PathVariable Integer id) {
        return papersService.getPaper(id);
    }

    @PostMapping("")
    public void createPaper(@RequestBody papers paper) {
        papersService.addPaper(paper);
    }

    @PutMapping("")
    public void updatePaper(@RequestBody papers paper) {
        papersService.updatePaper(paper);
    }

    @DeleteMapping("/{id}")
    public void deletePaper(@PathVariable Integer id) {
        papersService.deletePaper(id);
    }

    @GetMapping("/show")
    public ModelAndView showAllPapers(Model model) {
        List<papers> paperss = papersService.getAllPapers();
        return new ModelAndView("papers_list").addObject("paperss", paperss);
    }
}
