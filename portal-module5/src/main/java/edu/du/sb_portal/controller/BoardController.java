package edu.du.sb_portal.controller;

import edu.du.sb_portal.entity.Board;
import edu.du.sb_portal.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String getAllBoards(Model model) {
        List<Board> boards = boardService.getAllBoard();
        model.addAttribute("boards", boards);
        return "module5/board";
    }

    @GetMapping("/boards/{id}")
    public String getBoardById(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "module5/boardDetail";
    }

    @GetMapping("/boardWrite")
    public String boardWriteForm() {
        return "/module5/boardWrite";
    }

    @PostMapping("/boards")
    public String createBoard(Board board) {
        boardService.createBoard(board);
        return "redirect:/boards";
    }

    @PostMapping("/boards/delete/{id}")
    public String deleteBoardById(@PathVariable Long id) {
        boardService.deleteBoardById(id);
        return "redirect:/boards";

    }

    @GetMapping("/boards/edit/{id}")
    public String editBoardForm(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "module5/boardEdit";
    }

    @PostMapping("/boards/{id}")
    public String updateBoard(@PathVariable Long id, Board updatedBoard) {
        boardService.updateBoard(id, updatedBoard);
        return "redirect:/boards";
    }
}