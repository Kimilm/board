package kimilm.board.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kimilm.board.domain.BoardDomain;

public interface BoardDao extends JpaRepository<BoardDomain, Integer> {
	
	BoardDomain save(BoardDomain boardDomain);
	BoardDomain findByBoardNo(int boardNo);
	Page<BoardDomain> findAll(Pageable pageable);
	Page<BoardDomain> findByBoardTitleContaining(String boardTitle, Pageable pageable);
	void deleteByBoardNo(int boardNo);
}