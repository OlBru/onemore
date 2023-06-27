package com.example.onemore.Controllers;

import com.example.onemore.models.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.onemore.models.buysell;
import com.example.onemore.Services.BuysellService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MainpageController {

    @GetMapping("/mainpage_show")
    public ModelAndView showMainpage(Model model) {
        return new ModelAndView("mainpage");
    }
}
