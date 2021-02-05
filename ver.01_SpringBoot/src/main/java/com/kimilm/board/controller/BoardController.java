package com.kimilm.board.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kimilm.board.dto.BoardVO;
import com.kimilm.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/index")
    public String index(Model model) {
        System.out.println(model.toString());
        List<BoardVO> index = boardService.boardAll();
        model.addAttribute("index", index);

        // for (int i = 0; i < index.size(); ++i)
        // System.out.println(index.get(i).toString());

        return "index";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
        Map<String, Object> search = new HashMap<>();
        search.put("search", request.getParameter("search"));
        System.out.println(search.get("search"));

        List<BoardVO> result = boardService.boardSearch(search);
        System.out.println(result.toString());

        model.addAttribute("search", result);

        return "search";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/read")
    public String read(Model model) {
        BoardVO row = boardService.boardRead();
        model.addAttribute("result", row);

        return "read";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        List<BoardVO> index = boardService.boardAll();
        model.addAttribute("update", index);

        return "update";
    }

    @RequestMapping("/save/c")
    public String saveC(HttpServletRequest request, Model model) {
        Map<String, Object> create = new HashMap<>();
        create.put("title", request.getParameter("title"));
        create.put("content", request.getParameter("content"));
        // create.put("date", )

        // BoardVO save = boardService.boardSaveC(create);
        boardService.boardSaveC(create);

        // model.addAttribute("read", save);

        // return "read";
        return "index";
    }

    @RequestMapping("/save/u")
    public String saveU(Model model) {
        List<BoardVO> index = boardService.boardAll();
        model.addAttribute("read", index);

        return "read";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
        Map<String, Object> delete = new HashMap<>();
        delete.put("delete", request.getParameter("delete"));

        System.out.println(delete.get("delete"));

        // boardService.boardDelete(delete);

        // return delete;
        // return new RedirectView("/index");
        return "delete";
    }

    @RequestMapping("/rm")
    public String rm(HttpServletRequest request, Model model) {
        Map<String, Object> rm = new HashMap<>();
        rm.put("result", request.getParameter("title"));

        System.out.println(rm.get("result"));

        boardService.boardRM(rm);

        System.out.println("delete");

        // return delete;
        // return new RedirectView("/index");
        return "index";
    }
}
