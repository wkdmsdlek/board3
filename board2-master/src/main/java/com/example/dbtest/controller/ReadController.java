package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardCMT;
import com.example.dbtest.boardCMTService;
import com.example.dbtest.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ReadController {

    @Autowired
    private boardService boardService;

    @Autowired
    private boardCMTService boardCMTService;



    @GetMapping("/read/{bid}")
    public String read(@PathVariable int bid, Model model) {
        // 게시물 ID를 기반으로 게시물 정보 조회
        board board = boardService.getBoardById(bid);
        List<boardCMT> boardCMTList = boardCMTService.getAllCommentsByBoardId(bid);
        // 조회된 게시물 정보와 댓글 목록을 모델에 추가
        model.addAttribute("board", board);
        model.addAttribute("boardCMT", boardCMTList);

        // read 페이지로 이동
        return "read";
    }
    @PostMapping("/comment")
    public String createComment(@RequestParam("bid") int boardId,
                                @RequestParam("writerName") String writerName,
                                @RequestParam("comment") String commentContent) {
        boardCMT comment = new boardCMT();
        comment.setBid(boardId);
        comment.setwriterName(writerName);
        comment.setCmtContent(commentContent);

        boardCMTService.createComment(comment);

        return "redirect:/read/" + boardId;
    }
    @PostMapping("/comment/delete")
    public String deleteComment(@RequestParam("cmtId") int cmtId,
                                @RequestParam("bid") int boardId) {
        boardCMTService.deleteComment(cmtId);
        return "redirect:/read/" + boardId;
    }




}
