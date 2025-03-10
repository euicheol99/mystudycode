package com.kh.notice.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.vo.NoticeInfo;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	public int selectNoticeCount() {
		Connection conn = getConnection();
		
		int noticeCount = new NoticeDao().selectNoticeCount(conn);
		
		return noticeCount;
	}
	
	public ArrayList<Notice> selectNotice(NoticeInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNotice(conn,pi);
		
		close (conn);
		
		return list;
	}
}
