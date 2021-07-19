package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weapon/form")
public class WeaponFormController {
    public final WeaponService weaponService;

    @GetMapping("/add")
    public String weaponForm (Model model){
        model.addAttribute("weapon", new Weapon());
        return "/weapon/form";
    }

}
