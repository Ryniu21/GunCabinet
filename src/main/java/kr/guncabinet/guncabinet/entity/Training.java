package kr.guncabinet.guncabinet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private Date trainingDate;

    @ManyToOne
    private Weapon weapon;

    @ManyToOne
    private User user;

    private int ammoShootAtTraining;



}
