package com.example.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class boardCMTService {
    private final com.example.dbtest.boardCMTRepository boardCMTRepository;

    @Autowired
    public boardCMTService(boardCMTRepository boardCMTRepository) {
        this.boardCMTRepository = boardCMTRepository;
    }

    public boardCMT createComment(boardCMT comment) {
        comment.setCmtTime(LocalDateTime.now());
        return boardCMTRepository.save(comment);
    }

    public List<boardCMT> getAllComments() {
        return boardCMTRepository.findAll();
    }
    public List<boardCMT> getAllCommentsByBoardId(int boardId) {
        return boardCMTRepository.findByBoardIdOrderByCmtTimeDesc(boardId);
    }

    public boardCMT updateComment(boardCMT comment) {
        if (comment.getEditCmtTime() == null) {
            comment.setEditCmtTime(LocalDateTime.now());
        }
        return boardCMTRepository.save(comment);
    }
    public boardCMT getCommentById(int commentId) {
        return boardCMTRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글이 존재하지 않습니다."));
    }

    public void deleteComment(int cmtId) {
        boardCMTRepository.deleteById(cmtId);
    }


    public void deleteCommentsByBoardId(int bid) {
        List<boardCMT> comments = boardCMTRepository.findByBoardId(bid);
        boardCMTRepository.deleteAll(comments);
    }

}
