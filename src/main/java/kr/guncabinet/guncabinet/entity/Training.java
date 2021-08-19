package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = Training.TABLE_NAME)
public class Training {
    public static final String TABLE_NAME = "trainings";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type="date")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date trainingDate;

    @ManyToOne
    private Weapon weapon;

    @ManyToOne
    private User user;

    @Min(0)
    private int ammoShootAtTraining;
}
