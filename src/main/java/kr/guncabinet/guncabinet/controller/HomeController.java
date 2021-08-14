package kr.guncabinet.guncabinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/") // akcja testowa dostępna dla wszystkich
    //@ResponseBody
    public String home() { return "/home"; }

    @GetMapping("/home") // akcja dostępna tylko zalogowanych
    public String addingWeapon() { return "/home"; }

    @GetMapping("/archive/list")
    public String archive() { return "/archive/list"; }

    @GetMapping("/about")
    public String about() { return "/about"; }


}
