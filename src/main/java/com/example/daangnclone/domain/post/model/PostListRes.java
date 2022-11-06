package com.example.daangnclone.domain.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostListRes {
    private Long id;
    private String title;
    private String category;
    private Long price;
    private Boolean isSuggested;
    private String content;
}
