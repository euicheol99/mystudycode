package com.kh.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeInfo {

	private int listCount; //현재 총 게시글 수
	private int currentPage; //현재 페이지(사용자가 요청한 페이지)
	private int pageLimit = 10; //하단에 보여질 페이징바의 수
	private int boardLimit = 10; //한 페이지내에 보여질 게시글 최대 수
	//위 4개의 값을 기준으로 아래 3개의 값을 계산
	
	private int maxPage; //가장 마지막 페이지(총 페이지 수)
	private int startPage; //하단에 보여질 페이징바의 시작 수
	private int endPage; //하단에 보여질 페이징바의 끝 수
	
	public NoticeInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		this.startPage = (((currentPage - 1) / pageLimit)*pageLimit + 1);
		
		this.endPage = startPage + pageLimit - 1;
		
		this.endPage = endPage > maxPage ? maxPage : endPage;
	} 
	
}
