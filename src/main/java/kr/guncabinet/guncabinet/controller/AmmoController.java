package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.service.AmmoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        //return ammoService.getAllAmmunitionForUser().toString();
        model.addAttribute("ammos", ammoService.getAllAmmunitionForUser());
        return "/ammunition/form";
    }


    @PostMapping("/form")

    public String buyAmmunition(List<Ammo> ammunitions, BindingResult result){
        for (Ammo ammo:ammunitions) {
            ammo.setAmmoCount(10);
        }

        return "redirect:/weapon/all";
    }


}
