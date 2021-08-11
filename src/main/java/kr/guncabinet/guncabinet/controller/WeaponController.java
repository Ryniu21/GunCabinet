package kr.guncabinet.guncabinet.controller;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weapon")
public class WeaponController {
    public final WeaponService weaponService;
    public final CaliberService caliberService;
    public final UserService userService;
    public final AmmoService ammoService;


    @ModelAttribute("calibers")
    public List<Caliber> getAllCalibers(){return caliberService.getAllCalibers();}

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
    public String showOneWeapon(@PathVariable Long id, Model model){
        model.addAttribute(weaponService.findWeaponByWeaponID(id));
        return "/weapon/show";
    }


    @GetMapping("/archive/{id}")
    public String archiveWeapon(@PathVariable Long id, Model model){
        model.addAttribute("weapon", weaponService.findWeaponByWeaponID(id));
        System.out.println("GETA");
       return "/weapon/archive";
    }

    @PostMapping("/archive/{id}")
    public String archiveWeapon(Weapon weapon) {
        weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security

        weaponService.saveWeapon(weapon);
        System.out.println("POST1A");

        return "redirect:/weapon/archive/list";
    }



//    @PostMapping("/archive/{id}")
//    @ResponseBody
//    public String archiveWeapon(@Valid Weapon weapon, BindingResult result,@PathVariable Long id, @PathVariable Date dateSold, Ammo ammo) {
//        System.out.println("POST1A");
//        if (weapon.getId() == id) {
//            if (result.hasErrors()) {
//                return "/weapon/archive";
//            }
//            weapon.setDateSold(dateSold);
//            weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())); //Zaciąganie danych dla usera aktualnego ze spring security
//            ammo.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
//            ammoService.saveNewAmmo(weapon.getUser(), weapon.getCaliber());
//            weaponService.archive(weapon);
//        }
//        return "redirect:/archive/all";
//    }



}
