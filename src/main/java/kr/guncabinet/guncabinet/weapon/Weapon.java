package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column (nullable = false)
    @Size(min = 2, max = 50, message = "Please enter between {min} and {max} characters.")
    private String name;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Caliber caliber;

    @Min(0)
    private int ammoShoot;

    @NotEmpty
    private String permission;

    @Type(type="date")
    @NotNull(message = "Uzupełnij Datę")
    private Date dateBought;


    @Type(type="date")
    private Date dateSold;
    
    @ManyToOne
    private User user;

    @Transient
    private Ammo ammo;
}
