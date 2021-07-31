package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.Ammo;
import kr.guncabinet.guncabinet.entity.Caliber;
import kr.guncabinet.guncabinet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AmmoRepository extends JpaRepository<Ammo, Long> {

    Ammo findAmmoByUserAndCaliber (User user, Caliber caliber);

}
