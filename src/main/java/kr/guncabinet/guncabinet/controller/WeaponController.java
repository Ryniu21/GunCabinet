package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.repository.WeaponRepository;
import kr.guncabinet.guncabinet.service.WeaponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class WeaponController {
    private final WeaponService weaponService;

    @GetMapping("/add/weapon")
    @ResponseBody
    public String createWeapon(Weapon weapon){
       weaponService.saveWeapon(weapon);

       return "added weapon";
    }

    @GetMapping("/add/weapon1")
    @ResponseBody
    public String createWeapon1(Weapon weapon){
        weaponService.saveWeapon1(weapon);

        return "added weapon";
    }

}
