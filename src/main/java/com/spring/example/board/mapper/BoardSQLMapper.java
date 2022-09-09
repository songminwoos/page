package com.spring.example.board.mapper;

import java.util.ArrayList;

import com.spring.example.vo.BoardVo;

public interface BoardSQLMapper {

	/* 게시글 작성 쿼리 */	
	public void insertBoard(BoardVo param);

	/*게시글 목록 출력 (1개행일떄는 단일객체 리턴 1개이상일떈 ArrayList 리턴)*/
	public ArrayList<BoardVo> getBoardList(); 
	
	/*게시글 제목 검색 목록 출력 */
	public ArrayList<BoardVo> getBoardByTitle(String titlte);
	
	/* 게시글 내용 검색 목록 출력 */
	public ArrayList<BoardVo> getBoardByContent(String content);
	
	/* 게시글 작성자 검색 목록 출력 */	
	public ArrayList<BoardVo> getBoardByNickName(String nickname);
	
	/*게시글 번호 출력*/
	public BoardVo getBoardByNo(int no);
	
	/* 조회수 증가 쿼리 */
	public void increaseReadCount(int no);
	
	/* 게시글 수정 쿼리 */
	public void updateBoard(BoardVo param);
	
	/* 게시글 삭제 쿼리*/
	public void deleteBoard(int no);
}
