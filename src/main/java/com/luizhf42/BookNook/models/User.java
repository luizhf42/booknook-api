package com.luizhf42.BookNook.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    String id;
    @Column(name = "username", nullable = false, length = 30)
    String username;
    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "picture", nullable = false)
    String picture;
}
