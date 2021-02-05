package kimilm.board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kimilm.board.dao.CommentDao;
import kimilm.board.domain.CommentDomain;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	public CommentDomain findByCommentNo(int commentNo) {
		return commentDao.findByCommentNo(commentNo);
	}
	public List<CommentDomain> findByBoardNo(int boardNo) {
		return commentDao.findByBoard_BoardNo(boardNo);
	}
	
	public CommentDomain save(CommentDomain commentDomain) {
		return commentDao.save(commentDomain);
	}
	
	public void deleteByCommentNo(int commentNo) {
		commentDao.deleteByCommentNo(commentNo);
	}
}
