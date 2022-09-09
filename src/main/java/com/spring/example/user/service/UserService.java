package com.spring.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.user.mapper.UserSQLMapper;
import com.spring.example.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserSQLMapper userSQLMapper;
	
	public void insertUser(UserVo param) {
	
		userSQLMapper.insertUser(param);
	}
	
	public int checkId (String user_id) {	
		return userSQLMapper.checkId(user_id);
	}
	
	public int checkEmail(String user_email) {
		return userSQLMapper.checkEmail(user_email);
	}
	
	public int checkNickName(String user_nickname) {
		return userSQLMapper.checkNickName(user_nickname);
	}
	
	public int checkPhoneNumber(String user_phone) {
		return userSQLMapper.checkPhoneNumber(user_phone);
	}
	
	public UserVo login(UserVo userVo) {
		return userSQLMapper.selectByIdAndPw(userVo);
	}
	
}
