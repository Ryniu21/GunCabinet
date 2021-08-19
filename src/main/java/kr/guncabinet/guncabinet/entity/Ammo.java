package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

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
    @NotNull
    private Caliber caliber;

    @ColumnDefault("0")
    @Min(0)
    private int ammoCount;

    @ManyToOne
    private User user;

    public Ammo(Caliber caliber, User user) {
        this.caliber = caliber;
        this.user = user;
    }
    @Transient
    private Integer ammoBought;

    @Transient
    private Integer ammoShootOnTraining;

    @Type(type="date")
    @Transient
    private Date dateOfTransaction;



}
