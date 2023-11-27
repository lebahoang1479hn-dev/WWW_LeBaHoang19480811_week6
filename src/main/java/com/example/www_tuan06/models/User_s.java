package com.example.www_tuan06.models;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User_s {
    private String mobile;
    @Column(name = "last_login", columnDefinition = "datetime(10)")
    private LocalDateTime lastLogin;
    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;
    private String intro;
    private String profile;
    @Column(name = "registered_at", columnDefinition = "datetime(10)")
    private LocalDateTime registeredAt;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments;
    @Column(name = "password_hash", columnDefinition = "varchar(32)")
    private String passwordHash;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "middle_name", columnDefinition = "varchar(50)")
    private String middleName;
    @OneToMany(mappedBy = "author")
    private Set<Post>  posts = new LinkedHashSet<>();
    @Column(name = "firts_name", columnDefinition = "varchar(50)")
    private String firstName;
    private String email;
}
