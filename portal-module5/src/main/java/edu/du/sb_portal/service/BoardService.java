package edu.du.sb_portal.service;

import edu.du.sb_portal.entity.Board;
import edu.du.sb_portal.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public boolean deleteBoardById(Long id) {
        if (boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Board updateBoard(Long id ,Board updateboard) {
        Board board = boardRepository.findById(id).orElse(null);
        if( board != null) {
            board.setTitle(updateboard.getTitle());
            board.setContents(updateboard.getContents());
            return boardRepository.save(board);
        }
        return null;
    }

}
