package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.service.AmmoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/ammunition")
public class AmmoController {
    public final AmmoService ammoService;

    @GetMapping("/list")
    public String getAllAmmunition(Model model){
        model.addAttribute("ammos", ammoService.getAllAmmunitionForUser());
        return "/ammunition/list";
    }

    @GetMapping("/form")
    public String getAllAmmunitionShop(Model model){
        model.addAttribute("ammos", ammoService.getAllAmmunitionForUser());
        return "/ammunition/form";
    }


    @PostMapping("/form")
    @ResponseBody
    public String buyAmmunition(){
        Integer ammoToAdd;
        List<Ammo> ammunitions = ammoService.getAllAmmunitionForUser();
        for (Ammo ammo: ammunitions
             ) {
            ammoToAdd = 1111;
            ammo.setAmmoCount(ammo.getAmmoCount()+ammoToAdd);
        }

        return ammunitions.toString();
    }


}
