package com.example.daangnclone.domain.post.service;

import com.example.daangnclone.domain.post.model.PostListRes;
import com.example.daangnclone.domain.post.repository.ClipboardRepository;
import com.example.daangnclone.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ClipboardRepository clipboardRepository;


    /**
     *
     * 중고 거래 물품 게시글 전체 리스트 조회
     *
     * @author jswa7
     * @version 1.0.0
     * 작성일 2022-08-23
    **/
    public List<PostListRes> findAll() {
        List<PostListRes> posts = new ArrayList<>();
        postRepository.findAll().forEach(p -> posts.add(PostListRes.builder()
                        .id(p.getId())
                        .title(p.getTitle())
                        .category(p.getCategory())
                        .price(p.getPrice())
                        .isSuggested(p.getIsSuggested())
                        .content(p.getContent())
                .build()));
        return posts;
    }
}
