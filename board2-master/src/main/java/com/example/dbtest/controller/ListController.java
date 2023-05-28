package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ListController {
    private final boardService boardService;

    public ListController(boardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String showBoardList(Model model) {
        List<board> boardList = boardService.getAllBoardsOrderByBoardTimeDesc();
        model.addAttribute("boardList", boardList);
        return "list";
    }

    //홈화면으로
    @GetMapping("/goToHome")
    public String goToHome() {
        return "redirect:/";
    }

    //게시물 조회
    @GetMapping("/board/{bid}")
    public String viewBoard(@PathVariable("bid") int bid, Model model) {
        // 게시물 ID에 해당하는 상세 페이지 로직 구현
        // ...

        return "board";
    }
}
