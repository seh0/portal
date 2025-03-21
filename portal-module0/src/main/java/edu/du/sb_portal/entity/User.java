package edu.du.sb_portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class User {

    @Id
    private  String id;

    private String password;
    private String name;
    private String email;
}
