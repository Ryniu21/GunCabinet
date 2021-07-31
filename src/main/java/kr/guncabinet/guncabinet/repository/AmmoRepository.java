package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.Ammo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AmmoRepository extends JpaRepository<Ammo, Long> {

    @Query("SELECT a FROM Ammo a WHERE a.user= ?1 and a.caliber=?1")
    Ammo findCaliberByUserIdAndCaliberId (int userId, int caliberId);
}
