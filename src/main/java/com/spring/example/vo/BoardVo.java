package com.spring.example.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class BoardVo {

	private int board_no;
	private int user_no;

	@NotNull
	@Length(min = 2, max = 100)
	private String board_title;

	@NotNull
	@Length(min = 1, max = 2000)
	private String board_content;

	private int board_readcount;
	private String board_secret;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date board_writedate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date board_updatewrite_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date board_readcount_writedate;

	public BoardVo() {
		super();
	}

	public BoardVo(int board_no, int user_no, String board_title, String board_content, int board_readcount,
			String board_secret, Date board_writedate, Date board_updatewrite_date, Date board_readcount_writedate) {
		super();
		this.board_no = board_no;
		this.user_no = user_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_readcount = board_readcount;
		this.board_secret = board_secret;
		this.board_writedate = board_writedate;
		this.board_updatewrite_date = board_updatewrite_date;
		this.board_readcount_writedate = board_readcount_writedate;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_readcount() {
		return board_readcount;
	}

	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}

	public String getBoard_secret() {
		return board_secret;
	}

	public void setBoard_secret(String board_secret) {
		this.board_secret = board_secret;
	}

	public Date getBoard_writedate() {
		return board_writedate;
	}

	public void setBoard_writedate(Date board_writedate) {
		this.board_writedate = board_writedate;
	}

	public Date getBoard_updatewrite_date() {
		return board_updatewrite_date;
	}

	public void setBoard_updatewrite_date(Date board_updatewrite_date) {
		this.board_updatewrite_date = board_updatewrite_date;
	}

	public Date getBoard_readcount_writedate() {
		return board_readcount_writedate;
	}

	public void setBoard_readcount_writedate(Date board_readcount_writedate) {
		this.board_readcount_writedate = board_readcount_writedate;
	}

	@Override
	public String toString() {
		return "BoardVo [board_no=" + board_no + ", user_no=" + user_no + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_readcount=" + board_readcount + ", board_secret="
				+ board_secret + ", board_writedate=" + board_writedate + ", board_updatewrite_date="
				+ board_updatewrite_date + ", board_readcount_writedate=" + board_readcount_writedate + "]";
	}


}