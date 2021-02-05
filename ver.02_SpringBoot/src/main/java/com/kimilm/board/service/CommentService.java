package com.kimilm.board.service;

import java.util.List;
import java.util.Map;

import com.kimilm.board.dao.CommentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public List<Object> commentAll(int boardNo) {
        return commentDAO.commentAll(boardNo);
    }

    public String getComment(int commentNo) {
        return commentDAO.getComment(commentNo);
    }

    public void insertComment(Map<String, Object> map) {
        commentDAO.insertComment(map);
    }

    public void updateComment(Map<String, Object> map) {
        commentDAO.updateComment(map);
    }

    public void deleteComment(int commentNo) {
        commentDAO.deleteComment(commentNo);
    }
}
