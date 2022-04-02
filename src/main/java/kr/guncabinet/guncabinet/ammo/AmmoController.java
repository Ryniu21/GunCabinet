package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.Training;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/ammunition")
public class AmmoController {
    public final AmmoService ammoService;
    public final WeaponService weaponService;
    public final TrainingService trainingService;

    @ModelAttribute("ammos")
    public List<Ammo> getAllAmmunitionForUser(){return ammoService.getAllAmmunitionForUser();}

    @GetMapping("/list")
    public String getAllAmmunition(Model model){
        model.addAttribute("ammos", ammoService.getAllAmmunitionForUser());
        return "/ammunition/list";
    }

    @GetMapping("/form/{id}")
    public String getAllAmmunitionShop(@PathVariable Long id, Model model){
        model.addAttribute("ammo", ammoService.getAmmoForId(id));
        System.out.println("AmmoGet");
        return "/ammunition/form";
    }

    @PostMapping("/form/{id}")
    public String buyAmmunition(@PathVariable Long id, HttpServletRequest request){
        Integer ammoBought = Integer.parseInt(request.getParameter("ammoBought"));
        Ammo ammo = ammoService.getAmmoForId(id);
        ammo.setAmmoCount(ammo.getAmmoCount()+ammoBought);
        ammoService.update(ammo);
        return "redirect:/ammunition/list";
    }

    @GetMapping("/training/{id}/{weaponid}")
    public String getAmmunitionForTraining(@PathVariable Long id, @PathVariable Long weaponid, Model model){
        model.addAttribute("weapon",weaponService.findWeaponByWeaponID(weaponid));
        model.addAttribute("ammo", ammoService.getAmmoForId(id));
        model.addAttribute("training", new Training());
        System.out.println("AmmoGet");
        return "/ammunition/training";
    }

    @PostMapping("/training/{id}/{weaponid}")
    public String substractAmmunition(@PathVariable Long id, @PathVariable Long weaponid, Weapon weapon, Ammo ammo, Training training, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "/ammunition/training";
        }
        Integer ammoShootOnTraining = Integer.parseInt(request.getParameter("ammoShootOnTraining"));
        String StringDate = request.getParameter("dateOfTransaction");
        Date date = Date.valueOf(StringDate);
        ammo = ammoService.getAmmoForId(id);
        weapon = weaponService.findWeaponByWeaponID(weaponid);
        weapon.setAmmoShoot(weapon.getAmmoShoot()+ammoShootOnTraining);
        ammo.setAmmoCount(ammo.getAmmoCount()-ammoShootOnTraining);
        ammoService.update(ammo);
        weaponService.update(weapon);
        training = new Training();
        training.setUser(ammo.getUser());
        training.setWeapon(weapon);
        training.setUser(weapon.getUser());
        training.setAmmoShootAtTraining(ammoShootOnTraining);
        training.setTrainingDate(date);
        trainingService.saveTraining(training);
        return "redirect:/weapon/all";
    }



}
