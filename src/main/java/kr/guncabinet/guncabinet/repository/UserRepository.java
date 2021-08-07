package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByMailIgnoreCase(String mail);

    //User findById(Long id);
}
