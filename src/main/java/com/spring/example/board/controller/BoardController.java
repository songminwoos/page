package com.spring.example.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.example.board.service.BoardService;
import com.spring.example.vo.BoardVo;
import com.spring.example.vo.UserVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping("mainPage")
	public String mainPage(Model model, String category, String keyword) {
		ArrayList<HashMap<String, Object>> dataList = boardService.getBoardList(category, keyword);

		if (category != null) {
			switch (category) {
			case "title":
			case "content":
			case "nick":
				model.addAttribute("dataList", dataList);
				return "board/mainPage";
			}
		}
		dataList = boardService.getBoardList("", "");
		model.addAttribute("dataList", dataList);
		return "board/mainPage";
	}

	@RequestMapping("writeContentPage")
	public String writeContentPage(@ModelAttribute("boardVo") BoardVo vo) {
		return "board/writeContentPage";
	}

	@RequestMapping("writeContentProcess")
	public String writeContentProcess(@Valid BoardVo param, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			// 에러를 List로 저장
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			return "board/writeContentPage";
		}

		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser"); // (중요)
		int userNo = sessionUser.getUser_no();
		param.setUser_no(userNo);

		System.out.println("user_no : " + param.getUser_no() + "");

		boardService.insertBoard(param);

		return "redirect:./mainPage";

	}

	@RequestMapping("readContentPage")
	public String readContentPage(int board_no, Model model) {

		boardService.increaseReadCount(board_no);

		HashMap<String, Object> map = boardService.getBoard(board_no);
		model.addAttribute("data", map);

		return "board/readContentPage";
	}

	@RequestMapping("updateContentPage")
	public String updateContentPage(int board_no, Model model) {

		HashMap<String, Object> map = boardService.getBoard(board_no);
		model.addAttribute("data", map);

		return "board/updateContentPage";
	}

	@RequestMapping("updateContentProcess")
	public String updateContentProcess(BoardVo param) {

		boardService.updateBoard(param);

		return "redirect:./readContentPage?board_no=" + param.getBoard_no();
	}

	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int board_no) {

		boardService.deleteBoard(board_no);

		return "redirect:./mainPage";
	}

}
