package com.spring.example.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.user.service.UserService;

@RestController
@RequestMapping("/user/*")

public class RestUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("checkId")
	public HashMap<String, Object> checkId (String user_id) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int Count = userService.checkId(user_id);
		
		if ( Count == 0 ) {
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
	
	@RequestMapping("checkEmail") 
	public HashMap<String, Object> checkEmail(String user_email) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int count = userService.checkEmail(user_email);
		
		if (count == 0) {
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
	
	@RequestMapping("checkNickName") 
	public HashMap<String, Object> checkNickName(String user_nickname) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int count = userService.checkNickName(user_nickname);
		
		if (count == 0) {
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		System.out.println("닉네임 중복체크");
		
		return data;
	}
	
	@RequestMapping("checkPhoneNumber") 
	public HashMap<String, Object> checkPhoneNumber(String user_phone) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int count = userService.checkPhoneNumber(user_phone);
		
		if (count == 0) {
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
}
