package com.spring.example.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.board.mapper.BoardSQLMapper;
import com.spring.example.user.mapper.UserSQLMapper;
import com.spring.example.vo.BoardVo;
import com.spring.example.vo.UserVo;

@Service
public class BoardService {

	@Autowired
	BoardSQLMapper boardSQLMapper;

	@Autowired
	UserSQLMapper userSQLMapper;

	public void insertBoard(BoardVo param) {
		boardSQLMapper.insertBoard(param);
	}

	public ArrayList<HashMap<String, Object>> getBoardList(String category, String keyword) {

		ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

		ArrayList<BoardVo> boardVoList = boardSQLMapper.getBoardList();

		if (category != null) {
			switch (category) {
			case "title":
				boardVoList = boardSQLMapper.getBoardByTitle(keyword);
				System.out.println("title : " + keyword + "");
				break;
			case "content":
				boardVoList = boardSQLMapper.getBoardByContent(keyword);
				System.out.println("content : " + keyword + "");
				break;
			case "nick":
				boardVoList = boardSQLMapper.getBoardByNickName(keyword);
				System.out.println("nick : " + keyword + "");
				break;
			}
		}

		for (BoardVo boardVo : boardVoList) {

			int userNo = boardVo.getUser_no(); // 작성자 번호...
			UserVo userVo = userSQLMapper.getUserByNo(userNo); // SELECT * FROM FP_MEMBER WHERE member_no = #{no}

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userVo", userVo);
			map.put("boardVo", boardVo);

			// 현재 글이...지금시간 -3 시간 보다 클때...
			Date writeDate = boardVo.getBoard_writedate();
			long writeTime = writeDate.getTime();

			long currentTime = System.currentTimeMillis();
			long targetTime = currentTime - 1000 * 60 * 60 * 3;

			if (writeTime > targetTime) {
				map.put("newKeyword", true);
			}

			dataList.add(map);
		}

		return dataList;

	}

	public HashMap<String, Object> getBoard(int board_no) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		BoardVo boardVo = boardSQLMapper.getBoardByNo(board_no);
		int userNo = boardVo.getUser_no();
		UserVo memberVo = userSQLMapper.getUserByNo(userNo);

		map.put("userVo", memberVo);
		map.put("boardVo", boardVo);

		return map;
	}

	public void increaseReadCount(int board_no) {
		try {
			BoardVo param = boardSQLMapper.getBoardByNo(board_no);
			Date writeDate = param.getBoard_readcount_writedate();
			
			long targetTime = writeDate.getTime() + 1000 * 60 * 60 * 24;
			Date targetDate = new Date(targetTime);
			Date tagetDate1 = new Date(System.currentTimeMillis());

			if (param.getBoard_readcount() < 1) {
				boardSQLMapper.increaseReadCount(board_no);
			}

			if (tagetDate1.after(targetDate)) {
				boardSQLMapper.increaseReadCount(board_no);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBoard(BoardVo param) {
		boardSQLMapper.updateBoard(param);
	}

	public void deleteBoard(int board_no) {
		boardSQLMapper.deleteBoard(board_no);
	}

}
