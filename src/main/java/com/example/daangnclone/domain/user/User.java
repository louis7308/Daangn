package com.example.daangnclone.domain.user;

import com.example.daangnclone.global.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    private String userId;
    private String phoneNumber;
    private String nickName;
    private String email;
    private String imageUrl;
}
