package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.repository.AmmoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AmmoService {
    private final AmmoRepository ammoRepository;
    private final UserService userService;

    @ModelAttribute("ammo")
    public void saveNewAmmo(User user, Caliber caliber) {
        Ammo ammo = ammoRepository.findAmmoByUserAndCaliber(user, caliber);
        if (ammo == null) {
            ammoRepository.save(new Ammo(caliber, user));
        }
    }

    public List<Ammo> getAllAmmunitionForUser(){
        List<Ammo> ammunitions = ammoRepository.findAmmoByUserUsername((userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getUsername());
        return ammunitions;
    }

    public List<Ammo> getAllAmmunitionForUserToEdit(){
        List<Ammo> ammunitions = ammoRepository.findAmmoByUserUsernameToEdit((userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getUsername());
        return ammunitions;
    }



}
