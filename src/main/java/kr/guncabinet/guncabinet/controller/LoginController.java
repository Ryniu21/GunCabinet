package kr.guncabinet.guncabinet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping(value = {"/action/login"})
    public String loginGet() {
        return "/action/login";
    }

    @PostMapping("/action/login")
    public String loginPost(){
        return "/weapon/form";
    }


}
