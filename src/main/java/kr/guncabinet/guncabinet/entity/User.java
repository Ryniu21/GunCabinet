package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ColumnDefault("1")
    private Set<Role> roles;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;
    private boolean enabled;
//    @OneToMany(mappedBy = "user")
//    private List<Weapon> weapons = new ArrayList<>();



}
