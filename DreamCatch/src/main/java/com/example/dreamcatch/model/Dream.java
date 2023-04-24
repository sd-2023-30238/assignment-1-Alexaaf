package com.example.dreamcatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dream{

    @Id
    @SequenceGenerator(name = "dream_sequence",
            sequenceName = "dream_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dream_sequence")
    private Long id;

    @Column(name = "date", nullable = false, unique = false)
    private Date date;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "stress_level", nullable = false)
    private int stress_level;

    @Column(name = "energy_level", nullable = false)
    private int energy_level;

    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(name = "description", nullable = false)
    private String dreamDescription;

    @Column(name = "category", nullable = false)
    private String dreamCategory;

    @Override
    public String toString() {
        return "Dream{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", stress_level=" + stress_level +
                ", energy_level=" + energy_level +
                ", uid=" + uid +
                ", dreamDescription='" + dreamDescription + '\'' +
                ", dreamCategory='" + dreamCategory + '\'' +
                '}';
    }
}
