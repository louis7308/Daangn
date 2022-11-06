package com.example.daangnclone.domain.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
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
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Clipboard> clipboard;
}
