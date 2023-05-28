package com.example.dbtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dbtest.boardService;
import com.example.dbtest.boardCMTService;
@Controller
public class DeleteController {

    private final boardService boardService;
    private final boardCMTService boardCMTService;

    public DeleteController(boardService boardService, com.example.dbtest.boardCMTService boardCMTService) {
        this.boardService = boardService;
        this.boardCMTService = boardCMTService;
    }

    @GetMapping("/delete/{bid}")
    public String showDeletePage(@PathVariable("bid") int bid, Model model) {
        model.addAttribute("bid", bid);
        return "delete";
    }

    @PostMapping("/delete/{bid}")
    public String deleteBoard(@PathVariable("bid") int bid) {
        boardCMTService.deleteCommentsByBoardId(bid);
        boardService.deleteBoard(bid);


        return "redirect:/list";
    }



}
