package com.hug.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping()
    public ModelAndView home(){
        return new ModelAndView("home");
    }

}
