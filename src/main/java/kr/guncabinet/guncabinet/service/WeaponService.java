package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.repository.AmmoRepository;
import kr.guncabinet.guncabinet.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WeaponService {
    private final WeaponRepository weaponRepository;
    private final AmmoRepository ammoRepository;
    private final UserService userService;
    @PersistenceContext
    EntityManager entityManager;


    public void saveWeapon(Weapon weapon){
        weaponRepository.save(weapon);
    }

    public void update(Weapon weapon){
        weaponRepository.save(weapon);
    }

    public void archive(Weapon weapon){
        weaponRepository.save(weapon);
    }

    public Weapon findWeaponByWeaponID(Long id){return weaponRepository.findWeaponById(id);}

    public List<Weapon> findWeaponByUserID(int id){return weaponRepository.findWeaponByUserId(id);}

    public List<Weapon> findWeaponByUserName(String username){return weaponRepository.getWeaponByUserName(username);}

    public List<Weapon> findWeaponByUserNameArchived(String username) {return weaponRepository.getWeaponByUserNameArchived(username);}

    public List<Weapon> getAllWeapons(){return entityManager.createQuery("select w from Weapon w where w.dateSold is null").getResultList();}

    public List<Weapon> getAllArchivedWeapons(){return entityManager.createQuery("select w from Weapon w where w.dateSold is not null").getResultList();}

    public List<Weapon> getAllWeaponsWithAmmunition() {
        List<Weapon> weapons = findWeaponByUserName((userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getUsername());
        weapons.stream()
                .forEach(w -> w.setAmmo(ammoRepository.findAmmoByUserAndCaliber(w.getUser(), w.getCaliber())));
        return weapons;
    }

    public List<Weapon> getAllArchivedWeaponsWithAmmunition() {
        List<Weapon> weapons = findWeaponByUserNameArchived((userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getUsername());
        weapons.stream()
                .forEach(w -> w.setAmmo(ammoRepository.findAmmoByUserAndCaliber(w.getUser(), w.getCaliber())));
        return weapons;
    }
}
