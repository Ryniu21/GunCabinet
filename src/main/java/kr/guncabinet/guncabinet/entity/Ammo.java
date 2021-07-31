package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = Ammo.TABLE_NAME)
public class Ammo {
    public static final String TABLE_NAME = "ammo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Caliber caliber;

    @ColumnDefault("0")
    private int ammoCount;

    @ManyToOne
    private User user;

    public Ammo(Caliber caliber, User user) {
        this.caliber = caliber;
        this.user = user;
    }

    //@ManyToOne
    //@JoinTable(name= "user_ammo", joinColumns = @JoinColumn(name = "user_id"),
    //        inverseJoinColumns = @JoinColumn(name = "ammo_id"))
    //private User user;


}
