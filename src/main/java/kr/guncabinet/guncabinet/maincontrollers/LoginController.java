package kr.guncabinet.guncabinet.controller;


import kr.guncabinet.guncabinet.user.User;
import kr.guncabinet.guncabinet.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping(value = "/login")
    public String loginGet(Model model) {
        model.addAttribute("user", new User());
        return "/login";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "weapon/form";
    }

    @GetMapping(value = "/logout")
    public String logoutGet() {
        return "/logout";
    }

    @PostMapping(value = "/logout")
    public String logoutPost() {
        return "/logout";
    }

    @GetMapping("/registry")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "/registry";
    }

    @PostMapping("/registry")
    public String add(@Valid User user, BindingResult result, RedirectAttributes attributes, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        User validateEmail = userService.findUserByMailIgnoreCase(user.getMail());
        if (validateEmail != null) {
            request.setAttribute("alreadyExist", "Użytkownik o podanym adresie email już istnieje");
            return "login/login";
        }
        if(result.hasErrors()){
            return "/registry";
        }
        User validateLogin = userService.findByUserName(user.getUsername());
        if (validateLogin != null) {
            request.setAttribute("alreadyExist", "Podany login jest już zajęty");
            return "/login";
        }
        userService.saveUser(user, getSiteURL(request));
        attributes.addFlashAttribute("verify", "Potwierdź swój adres email klikając w link zawarty w wiadomości");
        return "redirect:/login";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify/{code}")
    public String verifyUser(@PathVariable String code, RedirectAttributes attributes) {
        if (userService.verify(code)) {
            attributes.addFlashAttribute("verifySuccess", "Twoje konto zostało pomyślnie zweryfikowane. Możesz się zalogować");
            return "redirect:/login";
        } else {
            attributes.addFlashAttribute("verifyFail", "Nie mogliśmy zweryfikować Twojego konta. Możliwe że zostało już zweryfikowane lub kod weryfikacyjny jest nieprawidłowy.");
            return "redirect:/registry";
        }
    }



}
