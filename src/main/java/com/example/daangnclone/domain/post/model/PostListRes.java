package com.example.daangnclone.domain.post.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostListRes {
    private Long id;
    private String title;
    private String category;
    private Long price;
    private Boolean isSuggested;
    private String content;
}
