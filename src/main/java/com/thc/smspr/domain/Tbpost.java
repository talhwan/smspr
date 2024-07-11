package com.thc.smspr.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//2024-07-11 추가(클래스 처음 추가함)
@Getter
@Table
@Entity
public class Tbpost {
    @Id private String id;
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String content;

    protected Tbpost(){}
    private Tbpost(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public static Tbpost of(String title, String content){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        return new Tbpost(id, title, content);
    }

}
