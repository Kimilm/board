package kimilm.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kimilm.board.dao.BoardDao;
import kimilm.board.domain.BoardDomain;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public BoardDomain save(BoardDomain boardDomain) {
		return boardDao.save(boardDomain);
	}
	
	public BoardDomain findByBoardNo(int boardNo) {
		return boardDao.findByBoardNo(boardNo);
	}

	public Page<BoardDomain> findAll(Pageable pageable) {
		return boardDao.findAll(pageable);
	}
	
	public Page<BoardDomain> findByBoardTitleContaining(String boardTitle, Pageable pageable) {
		return boardDao.findByBoardTitleContaining(boardTitle, pageable);
	}
	
	public void deleteByBoardNo(int boardNo) {
		boardDao.deleteByBoardNo(boardNo);
	}
}