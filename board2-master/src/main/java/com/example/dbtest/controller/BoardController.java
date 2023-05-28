package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/write")
public class BoardController {

    private final boardService boardService;

    public BoardController(boardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String showWriteForm(Model model) {
        model.addAttribute("board", new board());
        return "write";
    }

    @PostMapping
    public String createBoard(@ModelAttribute("board") board board) {
        boardService.createBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showBoardList(Model model) {
        List<board> boardList = boardService.getAllBoards();
        model.addAttribute("boardList", boardList);
        return "list";
    }



}
