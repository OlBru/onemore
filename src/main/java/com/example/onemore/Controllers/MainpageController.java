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
@RequestMapping("/mainpage")
public class MainpageController {

    @GetMapping("/show")
    public ModelAndView showMainpage(Model model) {
        return new ModelAndView("mainpage");
    }
}
