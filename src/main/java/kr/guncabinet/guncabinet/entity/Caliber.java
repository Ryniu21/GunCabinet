package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Caliber{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "caliber")
//    private List<Ammo> ammos = new ArrayList<>();
//
//    @OneToMany(mappedBy = "caliber")
//    private List<Weapon> weapons = new ArrayList<>();

}
