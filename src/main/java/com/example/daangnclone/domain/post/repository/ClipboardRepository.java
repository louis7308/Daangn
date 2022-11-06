package com.example.daangnclone.domain.post.repository;

import com.example.daangnclone.domain.post.Clipboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipboardRepository extends JpaRepository<Clipboard, Long> {
    
}
