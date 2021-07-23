package kr.guncabinet.guncabinet.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = Training.TABLE_NAME)
public class Training {
    public static final String TABLE_NAME = "trainings";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime trainingDate;

    @ManyToOne
    private Weapon weapon;

    @ManyToOne
    private User user;




}
