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
    private BoardDAO boardDAO;

    public List<BoardVO> boardAll(Map<String, Integer> map) {
        return boardDAO.boardAll(map);
    }

    public List<Object> boardSearch(Map<String, Object> map) {
        return boardDAO.boardSearch(map);
    }

    public BoardVO getRow(Map<String, Object> map) {
        return boardDAO.getRow(map);
    }

    public Map<String, Object> getUserName2(Map boardNo) {
        return boardDAO.getUserName2(boardNo);
    }

    public String getUserName(Map boardNo) {
        return boardDAO.getUserName(boardNo);
    }

    public int lastInsertID() {
        return boardDAO.lastInsertID();
    }

    public int selectCount() {
        return boardDAO.selectCount();
    }

    public int searchCount(Map map) {
        return boardDAO.searchCount(map);
    }

    public void createRow(Map<String, Object> map) {
        boardDAO.createRow(map);
    }

    public void updateRow(Map<String, Object> map) {
        boardDAO.updateRow(map);
    }

    public void deleteRow(Map<String, Object> map) {
        boardDAO.deleteRow(map);
    }
}
