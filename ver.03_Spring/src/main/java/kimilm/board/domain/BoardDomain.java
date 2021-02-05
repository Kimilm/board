package kimilm.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="BoardDomain")
@Table(name = "tb_board")
public class BoardDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "boardNo")
	private Integer boardNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "boardDate")
	private Date boardDate;

	@Column(name = "boardTitle")
	private String boardTitle;

	@Column(name = "boardContent")
	private String boardContent;

	@OneToOne(fetch = FetchType.EAGER, optional = false) 
    @JoinColumn(name = "userNo")
	private UserDomain user;

	public UserDomain getUser() {
		return user;
	}

	public void setUser(UserDomain user) {
		this.user = user;
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public boolean equals(Object obj) {
		return this.boardNo == ((BoardDomain)obj).getBoardNo();
	}
}
