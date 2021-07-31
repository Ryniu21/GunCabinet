package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.entity.User;
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
    public String weaponForm (Weapon weapon, Ammo ammo, BindingResult result) {
        weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security
        ammo.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        ammoService.saveNewAmmo(ammo);
        weaponService.saveWeapon(weapon);



        return "redirect:/weapon/form";
    }


    @GetMapping("/list/{id}")
    public String weaponList(@PathVariable int id, Model model){
        model.addAttribute("weapons", weaponService.findWeaponByUserID(id));
        return "/weapon/form";
    }

//    @GetMapping("/alltest")
//    @ResponseBody
//    public String getAllWeaponsTest() {
//        return weaponService.getAllWeapons().toString();
//    }

    @GetMapping("/all")
    public String getAllWeapons(Model model) {
        model.addAttribute("weapons", weaponService.getAllWeapons());
        return "/weapon/list";
    }

}
