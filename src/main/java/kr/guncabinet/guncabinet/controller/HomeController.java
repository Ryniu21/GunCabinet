package kr.guncabinet.guncabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() { return "/home"; }

    @GetMapping("/home")
    public String addingWeapon() { return "/home"; }

    @GetMapping("/archive/list")
    public String archive() { return "/archive/list"; }

    @GetMapping("/about")
    public String about() { return "/about"; }


}
