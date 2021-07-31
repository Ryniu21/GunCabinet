package kr.guncabinet.guncabinet.service;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.entity.Weapon;
import kr.guncabinet.guncabinet.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
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
    @PersistenceContext
    EntityManager entityManager;


    public void saveWeapon(Weapon weapon){

        weaponRepository.save(weapon);
    }

    public List<Weapon> findWeaponByUserID(int id){return weaponRepository.findWeaponByUserId(id);}

    public List<Weapon> getAllWeapons(){return entityManager.createQuery("select w from Weapon w").getResultList();}


}
