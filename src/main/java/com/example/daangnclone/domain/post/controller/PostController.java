package com.example.daangnclone.domain.post.controller;

import com.example.daangnclone.domain.post.model.PostListRes;
import com.example.daangnclone.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostListRes> findAll() {
        return postService.findAll();
    }
}
