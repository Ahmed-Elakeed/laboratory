package com.alshorouk.laboratory.controller;

import com.alshorouk.laboratory.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/login")
    public ModelAndView showLoginPage(HttpSession session){
        if(session.getAttribute("logged")=="true"){
            return new ModelAndView("redirect:/patients/data");
        }
        return new ModelAndView("login");
    }

    @GetMapping(path = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @GetMapping(path = "/change-password-form")
    public ModelAndView showChangePasswordForm(HttpSession session){
        if(session.getAttribute("logged")!="true"){
            return new ModelAndView("login");
        }
        return new ModelAndView("changePassword");
    }
    @GetMapping(path = "change-email-form")
    public ModelAndView showChangeEmailForm(HttpSession session){
        if(session.getAttribute("logged")!="true"){
            return new ModelAndView("login");
        }
        return new ModelAndView("changeEmail");
    }



    @PostMapping(path = "/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if (adminService.login(email, password)) {
            session.setAttribute("logged","true");
            session.setAttribute("email",email);
            return new ModelAndView("redirect:/patients/data");
        } else {
            return new ModelAndView("login");
        }
    }
    @PostMapping(path = "/change-password")
    public String changePassword(@RequestParam String old_pass,@RequestParam String new_pass1,@RequestParam String new_pass2,HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return "login";
        }
        if (bCryptPasswordEncoder.matches(old_pass, adminService.findAdminByEmail((String) session.getAttribute("email")).getPassword()) && new_pass1.equals(new_pass2)){
            adminService.updatePassword((String) session.getAttribute("email"),new_pass1);
            session.invalidate();
            return "login";
        }else{
            return "changePassword";
        }
    }
    @PostMapping(path = "/change-email")
    public String changeEmail(@RequestParam String old_email,@RequestParam String new_email,HttpSession session){
        if (session.getAttribute("logged") != "true") {
            return "login";
        }
        if(session.getAttribute("email").equals(old_email)){
            adminService.updateEmail(old_email,new_email);
            session.invalidate();
            return "login";
        }else{
            return "changeEmail";
        }
    }
}
