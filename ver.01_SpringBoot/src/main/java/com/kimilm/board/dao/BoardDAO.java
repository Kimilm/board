package com.kimilm.board.dao;

import java.util.List;
import java.util.Map;

import com.kimilm.board.dto.BoardVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
    // index
    public List<BoardVO> boardAll();

    // search
    public List<BoardVO> boardSearch(Map search);

    // read
    public BoardVO boardRead();

    // update
    public BoardVO boardUpdate();

    // save.c
    public BoardVO boardSaveC(Map save);

    // save.u
    public BoardVO boardSaveU();

    // delete
    public void boardRM(Map delete);
}
