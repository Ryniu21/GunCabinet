package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@Table(name = User.TABLE_NAME)
public class User {

    //public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @Column(length = 50)
    private String mail;
    private String password;
    @ManyToOne
    private Role role;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    private boolean enabled;
//    @OneToMany(mappedBy = "user")
//    private List<Weapon> weapons = new ArrayList<>();



}
