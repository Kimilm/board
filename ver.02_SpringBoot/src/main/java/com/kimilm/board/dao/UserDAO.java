package com.kimilm.board.dao;

import java.util.Map;

import com.kimilm.board.dto.UserVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    public UserVO loginCheck(Map<String, String> map);

    public void registerUser(Map<String, Object> map);

    public String isUser(Map<String, Object> map);

    public UserVO viewUser(String userNo);
}
