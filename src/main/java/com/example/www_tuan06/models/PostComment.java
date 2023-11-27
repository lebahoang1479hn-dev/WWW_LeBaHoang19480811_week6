package com.example.www_tuan06.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_comment")
public class PostComment {
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments;
    private boolean published;
    private String content;
    @Column(name = "published_at", columnDefinition = "datetime(10)")
    private LocalDateTime publishedAt;
    @Column(name = "created_at", columnDefinition = "datetime(10)")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User_s user;
}
