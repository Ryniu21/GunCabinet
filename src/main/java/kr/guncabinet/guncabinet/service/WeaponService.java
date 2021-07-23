package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public void saveWeapon1(Weapon weapon) {
        weapon.setName("Colt 1911");
        Ammo ammo = new Ammo();
        ammo.setAmmoCount(200);
        ammo.setCaliber("0.45");
        weapon.setAmmo(ammo);
        //weapon.setAmmoShoot(50);
        weapon.setPermission("sportowe");
        weapon.setDateBought(LocalDateTime.now());
        weaponRepository.save(weapon);
    }

    public void saveWeapon2(Weapon weapon) {
        weapon.setName("M16");
        Ammo ammo = new Ammo();
        ammo.setAmmoCount(300);
        ammo.setCaliber("0.223");
        weapon.setAmmo(ammo);
        //weapon.setAmmoShoot(100);
        weapon.setPermission("sportowe");
        weapon.setDateBought(LocalDateTime.now());
        weaponRepository.save(weapon);
    }

    public void saveWeapon(Weapon weapon){
        weapon.setDateBought(LocalDateTime.now());
        weaponRepository.save(weapon);
    }


}
