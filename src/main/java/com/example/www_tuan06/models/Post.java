package com.example.www_tuan06.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean published;
    private String content;
    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(name = "meta_title", columnDefinition = "varchar(100)")
    private String metaTitle;
    private String summary;
    @Column(name = "create_at", columnDefinition = "datetime(10)")
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User_s author;
    @Column(name = "updated_at", columnDefinition = "datetime(10)")
    private LocalDateTime updatedAt;
    @Column(name = "published_at", columnDefinition = "datetime(10)")
    private LocalDateTime   publishedAt;
}
