package edu.du.sb_portal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "board")
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String title;
    private String contents;
    private LocalDate createAt;

    @PrePersist
    public void prePersist() {
        if (createAt == null) {
            createAt = LocalDate.now();
        }
    }
}
