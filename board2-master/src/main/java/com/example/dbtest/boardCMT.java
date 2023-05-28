package com.example.dbtest;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class boardCMT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_id")
    private Integer cmtId;


    @Column(name = "bid", nullable = false)
    private int boardId;

    @Column(name = "writer_id", nullable = false)
    private String writerName;

    @Column(name = "cmt_content", nullable = false)
    private String cmtContent;

    @Column(name = "cmt_time")
    private LocalDateTime cmtTime;

    @Column(name = "edit_cmt_time")
    private LocalDateTime editCmtTime;

    // Constructors, getter/setter, and other necessary methods

    public void setwriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public void setCmtTime(LocalDateTime CmtTime) {
        this.cmtTime = CmtTime;
    }

    public void setEditCmtTime(LocalDateTime editCmtTime) {
        this.editCmtTime = editCmtTime;
    }



    public void setBid(Integer boardId) {
        this.boardId = boardId;
    }


}
