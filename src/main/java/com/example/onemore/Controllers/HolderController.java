package com.example.onemore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.holder;
import com.example.onemore.Services.holderService;

import java.util.List;

@RestController
@RequestMapping("/holder")
public class HolderController {
    private final holderService holderService;

    @Autowired
    public HolderController(holderService holderService) {
        this.holderService = holderService;
    }

    @GetMapping("/all")
    public List<holder> getAllHolders() {
        return holderService.getAllHolders();
    }

    @GetMapping("/{id}")
    public holder getHolder(@PathVariable Integer id) {
        return holderService.getHolder(id);
    }

    @PostMapping("")
    public void addHolder(@RequestBody holder holder) {
        holderService.addHolder(holder);
    }

    @PutMapping("")
    public void updateHolder(@RequestBody holder holder) {
        holderService.updateHolder(holder);
    }

    @DeleteMapping("/{id}")
    public void deleteHolder(@PathVariable Integer id) {
        holderService.deleteHolder(id);
    }
}
