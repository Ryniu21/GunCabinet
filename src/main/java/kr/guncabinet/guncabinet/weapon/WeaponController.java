package kr.guncabinet.guncabinet.weapon;

import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.weapon.Weapon;
import kr.guncabinet.guncabinet.ammo.AmmoService;
import kr.guncabinet.guncabinet.service.*;
import kr.guncabinet.guncabinet.weapon.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String archiveWeapon(@Valid Weapon weapon, BindingResult result) {
        if(result.hasErrors()){
            return "/weapon/archive";
        }
        weapon.setUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));//Zaciąganie danych dla usera aktualnego ze spring security
        weaponService.saveWeapon(weapon);

        return "redirect:/weapon/archive/list";
    }

    @GetMapping("/archive/show/{id}")
    public String showOneWeaponArchive(@PathVariable Long id, Model model){
        model.addAttribute(weaponService.findWeaponByWeaponID(id));
        return "/archive/show";
    }

}
