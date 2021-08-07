package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = Weapon.TABLE_NAME)
public class Weapon {
    public static final String TABLE_NAME = "weapons";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn
    private Caliber caliber;
    private int ammoShoot;
    private String permission;
    @Column(name="date_bought")
    @Type(type="date")
    private Date dateBought;
    @Type(type="date")
    private Date dateSold;
    @ManyToOne
    private User user;

    @Transient
    private Ammo ammo;



}
