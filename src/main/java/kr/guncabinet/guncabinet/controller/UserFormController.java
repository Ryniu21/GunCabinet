package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserFormController {
    private final UserService userService;

    @GetMapping("/registry")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "/registry";
    }

    @PostMapping("/registry")
    public String add(User user, BindingResult result){
        userService.saveUser(user);
        return "/login";
    }
}
