package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.service.AmmoService;
import kr.guncabinet.guncabinet.service.UserService;
import kr.guncabinet.guncabinet.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weapon")
public class WeaponFormController {
    public final WeaponService weaponService;
    public final AmmoService ammoService;
    public final UserService userService;


    @ModelAttribute("ammunitions")
    public List<Ammo> getAllCalibers(){return ammoService.getAllCalibers();}

    @ModelAttribute("permissions")
    public List<String> permissionOptions() {
        List<String>  permissions = new ArrayList<>();
        permissions.add("sportowe");
        permissions.add("sportowe do celów koleksjonerskich");
        permissions.add("kolekcjonerski");
        permissions.add("do ochrony osobistej");
        return permissions;
    }

    @GetMapping("/form")
    public String weaponForm (Model model){
        model.addAttribute("weapon", new Weapon());
        return "/weapon/form";
    }

    @PostMapping("/form")
    public String weaponForm (Weapon weapon, BindingResult result) {
        weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security
        weaponService.saveWeapon(weapon);
        return "/weapon/form";
    }


}
