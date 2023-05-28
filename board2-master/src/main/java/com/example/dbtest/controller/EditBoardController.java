package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditBoardController {
    private final boardService boardService;

    public EditBoardController(boardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/edit/{bid}")
    public String showEditForm(@PathVariable("bid") int boardId, Model model) {
        board board = boardService.getBoardById(boardId);
        model.addAttribute("board", board);
        return "editBoard";
    }

    @PostMapping("/update")
    public String updateBoard(@RequestParam("bid") int bid, @ModelAttribute("board") board updateBoard) {
        boardService.updateBoard(bid, updateBoard);
        return "redirect:/list";
    }
}
