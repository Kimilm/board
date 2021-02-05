package com.kimilm.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// import com.kimilm.board.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("pre Interceptor");

        // HttpSession session = request.getSession();
        // Integer userNo = (Integer) session.getAttribute("userNo");
        // String userName = (String) session.getAttribute("userName");

        // if (userNo != null) {
        // session.setAttribute("userNo", userNo);
        // session.setAttribute("userName", userName);
        // return true;
        // } else
        // return false;

        return true;
    }
}
