package com.kimilm.board.service;

import java.util.List;
import java.util.Map;

import com.kimilm.board.dao.BoardDAO;
import com.kimilm.board.dto.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
    @Autowired
    BoardDAO boardDAO;

    public List<BoardVO> boardAll() {
        return boardDAO.boardAll();
    }

    public List<BoardVO> boardSearch(Map search) {
        return boardDAO.boardSearch(search);
    }

    public BoardVO boardRead() {
        return boardDAO.boardRead();
    }

    public BoardVO boardUpdate() {
        return boardDAO.boardUpdate();
    }

    public BoardVO boardSaveC(Map save) {
        return boardDAO.boardSaveC(save);
    }

    public BoardVO boardSaveU() {
        return boardDAO.boardSaveU();
    }

    public void boardRM(Map delete) {
        boardDAO.boardRM(delete);
    }
}
