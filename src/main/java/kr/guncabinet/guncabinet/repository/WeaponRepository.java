package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WeaponRepository extends JpaRepository<Weapon,Long> {

}
