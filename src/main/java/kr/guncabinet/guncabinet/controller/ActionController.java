package kr.guncabinet.guncabinet.controller;

import kr.guncabinet.guncabinet.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/action")
public class ActionController {
    public final WeaponService weaponService;
    public final CaliberService caliberService;
    public final UserService userService;
    public final AmmoService ammoService;
    public final TrainingService trainingService;


    @GetMapping("/training")
    public String getAllWeaponsForTraining(Model model) {
        model.addAttribute("weapons", weaponService.getAllWeaponsWithAmmunition());
        return "/action/training";
    }

    @GetMapping("/traininglist")
    public String getAllArchivedWeapons(Model model) {
        model.addAttribute("trainings", trainingService.getAllTrainingsForUser());
        return "/action/traininglist";
    }
}
