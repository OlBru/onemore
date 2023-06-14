package com.example.onemore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.buysell;
import com.example.onemore.Services.BuysellService;

import java.util.List;

@RestController
@RequestMapping("/buysell")
public class BuysellController {
    private final BuysellService buysellService;

    @Autowired
    public BuysellController(BuysellService buysellService) {
        this.buysellService = buysellService;
    }

    @GetMapping("/getall")
    public List<buysell> getAllBuysell() {
        return buysellService.getAllBuysell();
    }

    @GetMapping("/{id}")
    public buysell getBuysell(@PathVariable Integer id) {
        return buysellService.getBuysell(id);
    }

    @PostMapping("")
    public void addBuysell(@RequestBody buysell buysell) {
        buysellService.addBuysell(buysell);
    }

    @PutMapping("")
    public void updateBuysell(@RequestBody buysell buysell) {
        buysellService.updateBuysell(buysell);
    }

    @DeleteMapping("/{id}")
    public void deleteBuysell(@PathVariable Integer id) {
        buysellService.deleteBuysell(id);
    }
}
