package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.service.AmmoService;
import kr.guncabinet.guncabinet.service.CaliberService;
import kr.guncabinet.guncabinet.service.UserService;
import kr.guncabinet.guncabinet.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weapon")
public class WeaponFormController {
    public final WeaponService weaponService;
    public final CaliberService caliberService;
    public final UserService userService;
    public final AmmoService ammoService;


    @ModelAttribute("calibers")
    public List<Caliber> getAllCalibers(){return caliberService.getAllCalibers();}

    @ModelAttribute("permissions")
    public List<String> permissionOptions() {
        List<String>  permissions = new ArrayList<>();
        permissions.add("sportowe");
        permissions.add("sportowe do celów kolekcjonerskich");
        permissions.add("kolekcjonerski");
        permissions.add("do ochrony osobistej");
        permissions.add("myśliwskie");
        return permissions;
    }

    @GetMapping("/form")
    public String weaponForm (Model model){
        model.addAttribute("weapon", new Weapon());
        return "/weapon/form";
    }

    @PostMapping("/form")
    public String weaponForm (@Valid Weapon weapon, Ammo ammo, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("error");
            return "/weapon/form";
        }
        System.out.println("postA");
        weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security
        ammo.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        ammoService.saveNewAmmo(weapon.getUser(), weapon.getCaliber());
        weaponService.saveWeapon(weapon);

        return "redirect:/weapon/all";
    }


    @GetMapping("/edit/{id}")
    public String editWeapon(@PathVariable Long id, Model model){
        model.addAttribute("weapon", weaponService.findWeaponByWeaponID(id));
        System.out.println("GETU");
        return "/weapon/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @Valid Weapon weapon, Ammo ammo, BindingResult result) {
        if (weapon.getId() == id) {
            if (result.hasErrors()) {
                return "/weapon/form";
            }
            weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security
            ammo.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
            ammoService.saveNewAmmo(weapon.getUser(), weapon.getCaliber());
            weaponService.update(weapon);
            System.out.println("POSTU");
        }
        return "redirect:/weapon/all";
    }




}
