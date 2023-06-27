package com.example.onemore.Controllers;

import com.example.onemore.models.buysell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.holder;
import com.example.onemore.Services.HolderService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HolderController {
    private final HolderService holderService;

    @Autowired
    public HolderController(HolderService holderService) {
        this.holderService = holderService;
    }

    @GetMapping("/getallholder")
    public List<holder> getAllHolders() {
        return holderService.getAllHolders();
    }

    @GetMapping("/getholder{id}")
    public holder getHolder(@PathVariable Integer id) {
        return holderService.getHolder(id);
    }

    @PostMapping("/addholder")
    public void addHolder(@RequestBody holder holder) {
        holderService.addHolder(holder);
    }

    @PutMapping("/updateholder")
    public void updateHolder(@RequestBody holder holder) {
        holderService.updateHolder(holder);
    }

    @DeleteMapping("/deleteholder{id}")
    public void deleteHolder(@PathVariable Integer id) {
        holderService.deleteHolder(id);
    }

    @GetMapping("/show_holder")
    public ModelAndView showAllHolders(Model model) {
        List<holder> holders = holderService.getAllHolders();
        return new ModelAndView("holder_list").addObject("holders", holders);}
}
