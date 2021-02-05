package com.kimilm.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kimilm.board.service.BoardService;
import com.kimilm.board.service.CommentService;
import com.kimilm.board.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    private int rows = 10;

    @RequestMapping("/")
    public String index() {
        return "redirect:index/1";
    }

    @RequestMapping("/index/{currentPage}")
    public String index(HttpServletRequest request, @PathVariable int currentPage, Model model) {

        Map<String, Integer> queryPages = new HashMap<>();
        int calculatePage = (currentPage - 1) * rows; // 1 - > 0, 2 -> 10, 3 -> 20
        queryPages.put("start", calculatePage);
        queryPages.put("end", rows); // 0 - 9, 10 - 19, 20 - 29

        model.addAttribute("result", boardService.boardAll(queryPages));

        // for paging
        int articleCount = boardService.selectCount();
        int endPage = ((articleCount - 1) / rows) + 1;
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("endPage", endPage);

        System.out.println("/currentPage " + currentPage + " calculatePage " + calculatePage + "/ endPage " + endPage
                + "/ articleCount " + articleCount);

        return "index";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        int currentPage = 1;
        if (request.getParameter("page") != null) {
            currentPage = Integer.parseInt(request.getParameter("page"));
        }
        Map<String, Object> queryPages = new HashMap<>();
        int calculatePage = (currentPage - 1) * rows; // 1 - > 0, 2 -> 10, 3
        queryPages.put("start", calculatePage);
        queryPages.put("end", rows); // 0 - 9, 10 - 19, 20 - 29
        queryPages.put("search", request.getParameter("search"));
        System.out.println(queryPages.get("search"));

        model.addAttribute("result", boardService.boardSearch(queryPages));

        Map<String, Object> map = new HashMap<>();
        map.put("search", request.getParameter("search"));

        // for paging
        int articleCount = boardService.searchCount(map);
        int endPage = ((articleCount - 1) / rows) + 1;
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("search", request.getParameter("search"));

        return "search";
    }

    @RequestMapping("/read")
    public String index(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardNo", request.getParameter("boardNo"));

        // System.out.println(boardService.getRow(requestMap).toString());
        System.out.println(boardService.getUserName2(requestMap).toString());

        // model.addAttribute("result", boardService.getRow(requestMap));
        // model.addAttribute("userName", boardService.getUserName(requestMap));

        model.addAttribute("result", boardService.getUserName2(requestMap));

        model.addAttribute("comment", commentService.commentAll(Integer.parseInt(request.getParameter("boardNo"))));

        System.out.println(model.getAttribute("result"));
        System.out.println(model.getAttribute("comment"));

        return "read";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", request.getSession().getAttribute("userNo"));
        map.put("boardNo", request.getParameter("boardNo"));
        map.put("commentContent", request.getParameter("commentContent"));

        commentService.insertComment(map);

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.GET)
    public String updateComment(HttpServletRequest request, Model model) {
        model.addAttribute("boardNo", request.getParameter("boardNo"));
        model.addAttribute("commentNo", request.getParameter("commentNo"));
        model.addAttribute("commentContent",
                commentService.getComment(Integer.parseInt(request.getParameter("commentNo"))));

        return "/updateComment";
    }

    @RequestMapping(value = "/doUpdateComment", method = RequestMethod.POST)
    public String doUpdateComment(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("commentNo", request.getParameter("commentNo"));
        map.put("commentContent", request.getParameter("commentContent"));

        commentService.updateComment(map);

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteComment(HttpServletRequest request, Model model) {
        commentService.deleteComment(Integer.parseInt(request.getParameter("commentNo")));

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }

    @RequestMapping(value = "/saveCreate", method = RequestMethod.POST)
    public String saveCreate(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardTitle", request.getParameter("boardTitle"));
        requestMap.put("boardContent", request.getParameter("boardContent"));
        requestMap.put("userNo", request.getSession().getAttribute("userNo"));

        boardService.createRow(requestMap);
        int boardNo = boardService.lastInsertID();

        return "redirect:/read?boardNo=" + boardNo;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardNo", request.getParameter("boardNo"));

        // System.out.println(boardService.getRow(requestMap).toString());
        System.out.println(boardService.getUserName2(requestMap).toString());

        model.addAttribute("result", boardService.getUserName2(requestMap));

        return "update";
    }

    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardNo", request.getParameter("boardNo"));
        requestMap.put("boardTitle", request.getParameter("boardTitle"));
        requestMap.put("boardContent", request.getParameter("boardContent"));

        System.out.println(requestMap.toString());

        boardService.updateRow(requestMap);

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardNo", request.getParameter("boardNo"));

        model.addAttribute("result", requestMap);

        return "delete";
    }

    @RequestMapping("/remove")
    public String remove(HttpServletRequest request, Model model) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("boardNo", request.getParameter("boardNo"));

        boardService.deleteRow(requestMap);

        return "redirect:/";
    }

    @RequestMapping("/signIn")
    public String signIn(Model model) {
        return "signIn";
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, Model model) {
        if (userService.loginCheck(request.getParameter("userId"), request.getParameter("userPassword"),
                request.getSession())) {
            System.out.println("login success");
            return "redirect:/";
        } else {
            System.out.println("login fail");
            return "redirect:/signIn";
        }
    }

    @RequestMapping("/signUp")
    public String signUp(Model model) {
        return "signUp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model) {
        if (userService.registerUser(request)) {
            System.out.println("register success");

            return checkLogin(request, model);
            // return "redirect:/";
        } else {
            System.out.println("register fail");
            return "redirect:/signUp";
        }
    }

    @RequestMapping("/signOut")
    public String signOut(HttpServletRequest request, Model model) {
        System.out.println("logout");
        request.getSession().invalidate();
        return "redirect:/";
    }
}
