package com.kimilm.board.dto;

import java.sql.Date;

public class CommentVO {
    private int commentNo;
    private Date commentDate;
    private String commentContent;
    private int userNo;
    private int boardNo;

    public int getCommentNo() {
        return this.commentNo;
    }

    public void setCommentNo(int commentNo) {
        this.commentNo = commentNo;
    }

    public Date getCommentDate() {
        return this.commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getUserNo() {
        return this.userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getBoardNo() {
        return this.boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

}
