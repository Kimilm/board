package com.kimilm.board.dao;

import java.util.List;
import java.util.Map;

import com.kimilm.board.dto.BoardVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
    // all
    public List<BoardVO> boardAll(Map<String, Integer> map);

    public List<Object> boardSearch(Map<String, Object> map);

    // read
    public BoardVO getRow(Map<String, Object> map);

    public Map<String, Object> getUserName2(Map boardNo);

    public String getUserName(Map boardNo);

    public int lastInsertID();

    public int selectCount();

    public int searchCount(Map map);

    // create
    public void createRow(Map<String, Object> map);

    // update
    public void updateRow(Map<String, Object> map);

    // remove
    public void deleteRow(Map<String, Object> map);
}
