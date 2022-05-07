package com.alshorouk.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class Default {
    @GetMapping(path = "/")
    public ModelAndView getLoginPage(HttpSession session){
        if(session.getAttribute("logged")=="true"){
            return new ModelAndView("redirect:/patients/data");
        }
        return new ModelAndView("login");
    }
}
