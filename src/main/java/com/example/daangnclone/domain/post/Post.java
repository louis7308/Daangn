package com.example.daangnclone.domain.post;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    private String category;
    private Long price;
    private Boolean isSuggested;

    private String content;
}
