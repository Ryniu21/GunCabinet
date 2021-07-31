package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.repository.WeaponRepository;
import kr.guncabinet.guncabinet.service.AmmoService;
import kr.guncabinet.guncabinet.service.CaliberService;
import kr.guncabinet.guncabinet.service.UserService;
import kr.guncabinet.guncabinet.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weapon")
public class WeaponController {
    public final WeaponService weaponService;
    public final CaliberService caliberService;
    public final UserService userService;
    public final AmmoService ammoService;


    @GetMapping("/all")
    public String getAllWeapons(Model model) {
        model.addAttribute("weapons", weaponService.getAllWeaponsWithAmmunition());
        return "/weapon/list";
    }

    @GetMapping("/archive/list")
    public String getAllArchivedWeapons(Model model) {
        model.addAttribute("weapons", weaponService.getAllArchivedWeaponsWithAmmunition());
        return "/archive/list";
    }

    @GetMapping("/show/{id}")
    @ResponseBody
    public String showOneWeapon(Model model){
        return "showing one weapon";
    }

    @GetMapping("/archive/form/{id}")
    @ResponseBody
    public String archiveWeapon(Long id){
        return "archiving one weapon";
    }

    @GetMapping("/edit/{id}")
    public String editWeapon(@PathVariable Long id, Model model){
        model.addAttribute("weapon", weaponService.findWeaponByWeaponID(id));
        return "/weapon/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @Valid Weapon weapon, BindingResult result) {
        if (weapon.getId() == id) {
            if (result.hasErrors()) {
                return "/weapon/form";
            }
            weaponService.update(weapon);
        }
        return "redirect:/weapon/all";
    }

}
