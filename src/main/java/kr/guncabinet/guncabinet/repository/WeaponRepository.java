package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.User;
import kr.guncabinet.guncabinet.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WeaponRepository extends JpaRepository<Weapon,Long> {
    List<Weapon> findWeaponByUserId(int id);

    @Query("SELECT w FROM Weapon w where w.user = ?1")
    List<Weapon> getWeaponByUserId(int id);

}
