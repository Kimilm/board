package kimilm.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="UserDomain")
@Table(name="tb_user")
public class UserDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userNo")
	private Integer userNo;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "userPassword")
	private String userPassword;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userMail")
	private String userMail;
	
	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.userNo == ((UserDomain)obj).getUserNo();
	}
}
