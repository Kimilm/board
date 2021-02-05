package com.kimilm.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDAO {
    public List<Object> commentAll(int boardNo);

    public String getComment(int commentNo);

    public void insertComment(Map<String, Object> map);

    public void updateComment(Map<String, Object> map);

    public void deleteComment(int commentNo);
}
