package kimilm.board.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kimilm.board.domain.CommentDomain;

public interface CommentDao extends JpaRepository<CommentDomain, Integer> {
	
	CommentDomain findByCommentNo(int commentNo);
	List<CommentDomain> findByBoard_BoardNo(int boardNo);
	CommentDomain save(CommentDomain commentDomain);
	void deleteByCommentNo(int commentNo);
}