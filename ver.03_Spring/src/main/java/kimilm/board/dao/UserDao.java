package kimilm.board.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kimilm.board.domain.UserDomain;

public interface UserDao extends JpaRepository<UserDomain, Integer> {
	
	UserDomain findByUserIdAndUserPassword(String userId, String password);
	UserDomain findByUserNo(int userNo);
	UserDomain findByUserId(String userId);
	UserDomain save(UserDomain userDomain);
}