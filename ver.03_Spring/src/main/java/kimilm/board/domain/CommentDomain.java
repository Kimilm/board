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

@Entity(name="CommentDomain")
@Table(name = "tb_comment")
public class CommentDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentNo")
	private Integer commentNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "commentDate")
    private Date commentDate;
	
	@Column(name = "commentContent")
    private String commentContent;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false) 
    @JoinColumn(name = "userNo")
    private UserDomain user;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false) 
    @JoinColumn(name = "boardNo")
    private BoardDomain board;
	
	public Integer getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public UserDomain getUser() {
		return user;
	}

	public void setUser(UserDomain user) {
		this.user = user;
	}

	public BoardDomain getBoard() {
		return board;
	}

	public void setBoard(BoardDomain board) {
		this.board = board;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.commentNo == ((CommentDomain)obj).getCommentNo();
	}
}
