package kr.guncabinet.guncabinet.repository;

import kr.guncabinet.guncabinet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.mail = ?1")
    User findUserByMailIgnoreCase(String mail);

    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);

    @Query("SELECT u FROM User u WHERE 1=1")
    List<User> findAllUser();

    List<User> findAllByRoleId(int id);



}
