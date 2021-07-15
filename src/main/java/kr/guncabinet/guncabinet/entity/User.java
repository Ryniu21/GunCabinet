package kr.guncabinet.guncabinet.entity;

import lombok.Data;

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
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
