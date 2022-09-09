package com.spring.example.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class UserVo {
	private int user_no;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-zA-z])(?=.*[0-9])(?!.*[^a-zA-z0-9]).{5,20}")
	private String user_id;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-zA-z])(?=.*[0-9])(?!.*[^a-zA-z0-9]).{5,20}")
	private String user_pw;

	@NotNull
	@Length(min = 2, max = 10)
	private String user_nickname;

	@NotNull
	@Length(max = 13)
	@Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$")
	private String user_phone;

	@NotNull
	@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")
	private String user_email;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date user_birth;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date user_joindate;

	public UserVo() {
		super();
	}

	public UserVo(int user_no, String user_id, String user_pw, String user_nickname, String user_phone,
			String user_email, Date user_birth, Date user_joindate) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nickname = user_nickname;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_birth = user_birth;
		this.user_joindate = user_joindate;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}

	public Date getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(Date user_joindate) {
		this.user_joindate = user_joindate;
	}

	@Override
	public String toString() {
		return "UserVo [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_nickname="
				+ user_nickname + ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_birth="
				+ user_birth + ", user_joindate=" + user_joindate + "]";
	}
}
