package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = Weapon.TABLE_NAME)
public class Weapon {
    public static final String TABLE_NAME = "weapons";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true, length = 50)
    private String name;

    private String caliber;

    //@OneToMany
    private int ammoCount;
    private int ammoShoot;
    private String permission;
    private LocalDateTime dateBought;
    private LocalDateTime dateSold;

}
