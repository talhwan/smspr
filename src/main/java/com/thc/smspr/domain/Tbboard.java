package com.thc.smspr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//2024-07-11 추가(클래스 처음 추가함)
@Getter
@Table
@Entity
public class Tbboard {
    @Id private String id; //id 는 PK로 쓸꺼야!!
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String content;
    @Setter @Column(nullable = false) private String writer;

    protected Tbboard(){}
    private Tbboard(String id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    public static Tbboard of(String title, String content, String writer){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        return new Tbboard(id, title, content, writer);
    }

}
