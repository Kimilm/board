package com.kimilm.board.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kimilm.board.dao.UserDAO;
import com.kimilm.board.dto.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean loginCheck(String userId, String userPassword, HttpSession session) {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("userPassword", userPassword);
        UserVO user = userDAO.loginCheck(map);

        if (user != null) {
            session.setAttribute("userNo", user.getUserNo());
            session.setAttribute("userName", user.getUserName());
            return true;
        } else
            return false;
    }

    public boolean registerUser(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", request.getParameter("userId"));
        map.put("userPassword", request.getParameter("userPassword"));
        map.put("userName", request.getParameter("userName"));
        map.put("userMail", request.getParameter("userMail"));

        System.out.println(map.toString());

        if (isUser((String) request.getParameter("userId"))) {
            return false;
        } else {
            userDAO.registerUser(map);
            return true;
        }
    }

    public boolean isUser(String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        if (userDAO.isUser(map) != null)
            return true;
        else
            return false;
    }

    public UserVO viewUser(String userNo) {
        return userDAO.viewUser(userNo);
    }
}
