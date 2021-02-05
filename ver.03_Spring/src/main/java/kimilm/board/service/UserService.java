package kimilm.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kimilm.board.dao.UserDao;
import kimilm.board.domain.UserDomain;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;
	
	public UserDomain findByUserNo(int userNo) {
		return userDao.findByUserNo(userNo);
	}

	public boolean isUser(String userId) {
		UserDomain user = userDao.findByUserId(userId);

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean loginCheck(String userId, String userPassword, HttpSession session) {
		UserDomain user = userDao.findByUserIdAndUserPassword(userId, userPassword);

		if (user != null) {
			session.setAttribute("userNo", user.getUserNo());
			session.setAttribute("userName", user.getUserName());

			return true;
		} else {
			return false;
		}
	}

	public boolean registerUser(HttpServletRequest request) {
		UserDomain user = new UserDomain();

		user.setUserId(request.getParameter("userId"));
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserName(request.getParameter("userName"));
		user.setUserMail(request.getParameter("userMail"));

		if (isUser(user.getUserId())) {
			System.out.println("already User");
			return false;
		} else {
			userDao.save(user);
			return true;
		}
	}
}
