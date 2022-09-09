package com.spring.example.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.example.user.service.UserService;
import com.spring.example.vo.UserVo;

@Controller
@RequestMapping("/user/")

public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("userAgree")
	public String userPage() {
		return "user/userAgree";
	}

	@RequestMapping("joinUserPage")
	public String joinUserPage(@ModelAttribute("userVo") UserVo vo,
			@RequestParam(value = "agree", defaultValue = "false") boolean agree) {
		if (!agree) {
			return "user/userAgree";
		} else {
			return "user/joinUserPage";
		}
	}

	@RequestMapping("insertUserProcess")
	public String insertUserProcess(@Valid UserVo param, BindingResult result) {

		if (result.hasErrors()) {
			// 에러를 List로 저장
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			return "/user/joinUserPage";
		}

		userService.insertUser(param);

		return "user/joinUserCompletPage";
	}

	@RequestMapping("loginPage")
	public String loginPage() {
		return "/user/loginPage";
	}

	@RequestMapping("loginProcess")
	public String loginProcess(UserVo param, HttpSession session) {
		UserVo sessionUser = userService.login(param);
		if (sessionUser != null) {
			// 인증 성공
			// 여기 신경쓰자... session.setAttribute 딱 한번 활용됨... 앞으로 getAttribute 많이 쓴다...
			System.out.println("user_id : "+param.getUser_id()+"");
			System.out.println("user_pw : "+param.getUser_pw()+"");			
			session.setAttribute("sessionUser", sessionUser);
		}

		return "redirect:../board/mainPage";
	}

	@RequestMapping("loginoutProcess")
	public String loginoutProcess(HttpSession session) {
		session.invalidate(); // 세션 저장 공간을 날리고 재구성..

		return "redirect:./loginPage";
	}

}
