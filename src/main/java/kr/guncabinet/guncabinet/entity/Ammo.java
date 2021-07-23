package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = Ammo.TABLE_NAME)
public class Ammo {
    public static final String TABLE_NAME = "ammunitions";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caliber;

    private int ammoCount;

    //@ManyToMany
    //@JoinTable(name= "user_ammo", joinColumns = @JoinColumn(name = "user_id"),
    //        inverseJoinColumns = @JoinColumn(name = "ammo_id"))
    //private Set<User> users;


}
