package kimilm.board.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kimilm.board.domain.BoardDomain;
import kimilm.board.domain.CommentDomain;
import kimilm.board.domain.UserDomain;
import kimilm.board.service.BoardService;
import kimilm.board.service.CommentService;
import kimilm.board.service.UserService;

@Controller
public class BoardContoller {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	/* board */
	
	@RequestMapping("/")
	public String index() {
		return "redirect:index/1";
	}
	
	@RequestMapping("/index/{currentPage}")
	public String index(@PathVariable int currentPage, Model model) {
		Page<BoardDomain> page = boardService.findAll(PageRequest.of(currentPage - 1, 10, Sort.by("boardNo").descending()));
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("endPage", page.getTotalPages());
		model.addAttribute("result", page.getContent());
		
		return "index";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String boardTitle = request.getParameter("search");
		int currentPage = Integer.parseInt(request.getParameter("page"));
		Page<BoardDomain> page = boardService.findByBoardTitleContaining(boardTitle, PageRequest.of(currentPage - 1, 10, Sort.by("boardNo").descending()));
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("endPage", page.getTotalPages());
		model.addAttribute("result", page.getContent());
		model.addAttribute("search", boardTitle);
		
		return "search";
	}
	
	@RequestMapping("/read")
	public String read(HttpServletRequest request, Model model) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		model.addAttribute("result", boardService.findByBoardNo(boardNo));
		
		List<CommentDomain> comments = commentService.findByBoardNo(boardNo);
		
		model.addAttribute("comment", comments);
		
		return "read";
	}
	
	@RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }
	
	@RequestMapping(value = "/saveCreate", method = RequestMethod.POST)
    public String saveCreate(HttpServletRequest request, Model model) {
		BoardDomain board = new BoardDomain();
		UserDomain user = new UserDomain();
		
		user = userService.findByUserNo(Integer.parseInt(request.getSession().getAttribute("userNo").toString()));
		
		board.setBoardDate(new Date());
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));
		board.setUser(user);

        int boardNo = boardService.save(board).getBoardNo();

        return "redirect:/read?boardNo=" + boardNo;
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model) {
		BoardDomain board = boardService.findByBoardNo(Integer.parseInt(request.getParameter("boardNo")));

        model.addAttribute("result", board);

        return "update";
    }
	
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(HttpServletRequest request, Model model) {
		BoardDomain board = boardService.findByBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		
		board.setBoardTitle(request.getParameter("boardTitle"));
		board.setBoardContent(request.getParameter("boardContent"));

        boardService.save(board);

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }
	
	@RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {
		
		boardService.deleteByBoardNo(Integer.parseInt(request.getParameter("boardNo")));

        return "redirect:/";
    }
	
	/* comment */
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(HttpServletRequest request, Model model) {
		UserDomain user = userService.findByUserNo(Integer.parseInt(request.getSession().getAttribute("userNo").toString()));
		BoardDomain board = boardService.findByBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		
		CommentDomain comment = new CommentDomain();
		
		comment.setCommentDate(new Date());
		comment.setCommentContent(request.getParameter("commentContent"));
		comment.setBoard(board);
		comment.setUser(user);
		
		commentService.save(comment);

        return "redirect:/read?boardNo=" + request.getParameter("boardNo");
    }
	
	@RequestMapping(value = "/updateComment", method = RequestMethod.GET)
    public String updateComment(HttpServletRequest request, Model model) {
		CommentDomain commentDomain = commentService.findByCommentNo(Integer.parseInt(request.getParameter("commentNo")));
        
		model.addAttribute("comment", commentDomain);

        return "/updateComment";
    }
	
	@RequestMapping(value = "/doUpdateComment", method = RequestMethod.POST)
    public String doUpdateComment(HttpServletRequest request, Model model) {
		CommentDomain commentDomain = commentService.findByCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		
		commentDomain.setCommentDate(new Date());
		commentDomain.setCommentContent(request.getParameter("commentContent"));
		
        commentService.save(commentDomain);

        return "redirect:/read?boardNo=" + commentDomain.getBoard().getBoardNo();
    }
	
	@RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteComment(HttpServletRequest request, Model model) {
		CommentDomain comment = commentService.findByCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		int boardNo = comment.getBoard().getBoardNo();
		
		commentService.deleteByCommentNo(comment.getCommentNo());

        return "redirect:/read?boardNo=" + comment.getBoard().getBoardNo();
    }
	
	/* user */
	
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

