package com.example.dbtest;

import lombok.AccessLevel;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Entity
public class board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private int bid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "content", nullable = false)
    private String content;


    @Column(name = "board_time")
    private LocalDateTime boardTime;

    @Column(name = "edit_time")
    private LocalDateTime editTime;

    @Column(name = "views")
    private Integer views;

    @Column(name = "likes")
    private Integer likes;

    //생성자, getter/setter등 필요한 메소드들



    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public void setBoardTime(LocalDateTime boardTime) {
        this.boardTime = boardTime;
    }


    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }


}
