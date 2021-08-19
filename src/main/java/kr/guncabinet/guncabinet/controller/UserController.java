package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/adminlist")
    public String admin(Model model) {
        model.addAttribute("users", userService.finaAllUser());
        return "/admin/adminlist";
    }

    public boolean ifLastAdmin() {
        List<User> admins = userService.findAllByRoleId(2);
        if (admins.size() > 1) {
            return false;
        }
        return true;
    }

}
