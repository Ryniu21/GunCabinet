package kr.guncabinet.guncabinet.service;

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

    public void saveWeapon(Weapon weapon) {
        weapon.setName("Colt 1911");
        weapon.setCaliber("0.45ACP");
        weapon.setAmmoCount(200);
        weapon.setAmmoShoot(50);
        weapon.setPermission("sportowe");
        weapon.setDateBought(LocalDateTime.now());
        weaponRepository.save(weapon);
    }

    public void saveWeapon1(Weapon weapon) {
        weapon.setName("M16");
        weapon.setCaliber(".223");
        weapon.setAmmoCount(300);
        weapon.setAmmoShoot(100);
        weapon.setPermission("sportowe");
        weapon.setDateBought(LocalDateTime.now());
        weaponRepository.save(weapon);
    }

}
