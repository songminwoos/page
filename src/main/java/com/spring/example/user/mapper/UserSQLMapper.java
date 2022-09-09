package com.spring.example.user.mapper;

import com.spring.example.vo.UserVo;

public interface UserSQLMapper {
	
	public void insertUser(UserVo param);
	
	/* 아이디 중복 체크 */
	public int checkId(String user_id);
	
	/* 이메일 중복 체크 */
	public int checkEmail(String user_email);
	
	/* 닉네임 중복체크 */
	public int checkNickName(String user_nickname);
	
	/* 폰번호 중복체크 */
	public int checkPhoneNumber(String user_phone);
	
	/* 아이디 비밀번호 체크 */
	public UserVo selectByIdAndPw(UserVo param);
	
	/* 유저  PRIMARY KEY*/
	public UserVo getUserByNo(int no);
	

}
