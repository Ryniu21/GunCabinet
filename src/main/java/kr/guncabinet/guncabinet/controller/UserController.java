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


    //@GetMapping("/admin")
    //@ResponseBody
    //public String admin(@AuthenticationPrincipal CurrentUser customUser) {
    //    User entityUser = customUser.getUser();
    //    return "Hello " + entityUser.getUsername();
    //}

    @GetMapping("/admin/adminlist")
    public String admin(Model model) {
        model.addAttribute("users", userService.finaAllUser());
//        List<User> userList = userService.finaAllUser();
        return "/admin/adminlist";
//        return userList.toString();
    }


    public boolean ifLastAdmin() {
        List<User> admins = userService.findAllByRoleId(2);
        if (admins.size() > 1) {
            return false;
        }
        return true;
    }

}
