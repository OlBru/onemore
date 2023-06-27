package com.example.onemore.Controllers;

import com.example.onemore.Repositories.MediatorRepository;
import com.example.onemore.Services.MediatorService;
import com.example.onemore.models.issuer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.mediator;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MediatorController {
    private final MediatorRepository mediatorRepository;
    private final MediatorService mediatorService;

    @Autowired
    public MediatorController(MediatorService mediatorService, MediatorRepository mediatorRepository) {
        this.mediatorService = mediatorService;
        this.mediatorRepository = mediatorRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/getallmediator")
    public List<mediator> getAllMediators() {
        return mediatorService.getAllMediators();
    }

    @GetMapping("/getmediator{id}")
    public mediator getMediator(@PathVariable Integer id) {
        return mediatorService.getMediator(id);
    }

    @PostMapping("/createmediator")
    public void createMediator(@RequestBody mediator mediator) {
        mediatorService.addMediator(mediator);
    }

    @PutMapping("/updatemediator")
    public void updateMediator(@RequestBody mediator mediator) {
        mediatorService.updateMediator(mediator);
    }

    @DeleteMapping("/deletemediator{id}")
    public void deleteMediator(@PathVariable Integer id) {
        mediatorService.deleteMediator(id);
    }
    @GetMapping("/show_mediator")
    public ModelAndView showAllMediators(Model model) {
        List<mediator> mediators = mediatorService.getAllMediators();
        return new ModelAndView("mediator_list").addObject("mediators", mediators);}
}
