package kr.guncabinet.guncabinet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping(value = "/login")
    public String loginGet() {
        return "/login";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "weapon/form";
    }

//    @GetMapping(value = "/logout")
//    public String logoutGet() {
//        return "logout";
//    }
//
//    @PostMapping("/logout")
//    public String logoutPost(){
//        return "home";
//    }



}
