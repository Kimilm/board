package com.kimilm.board.dto;

import java.sql.Date;

public class BoardVO {
    private int boardNo;
    private Date boardDate;
    private String boardTitle;
    private String boardContent;

    public int getBoardNo() {
        return this.boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public Date getBoardDate() {
        return this.boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public String getBoardTitle() {
        return this.boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return this.boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

}
