package com.kh.jdbc.service;

//static으로 import시 static메서드를 직접 가져올 수 있음
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

public class MemberService {
	//1) JDBC driver등록
	//2) Connection객체 생성
	//3) Connection객체 처리
	private MemberDao md = new MemberDao();
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = md.insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public ArrayList <Member> selectList(){
		Connection conn = getConnection();
		ArrayList<Member> list = md.selectList(conn);
		
		
		close(conn);
		return list;
	}
	
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = md.deleteMember(userId, conn);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public ArrayList<Member> selectByUserName(String Keyword){
		Connection conn = getConnection();
		ArrayList<Member>list = md.selectByUserName(Keyword,conn);
		
		
		close(conn);
		return list;
	}
	
	public boolean checkId(String id) {
		for(Member m : this.selectList()) {
			if(m.getUserId().equals(id)) { 
				return true;
			}
		} 
		return false;
	}
	
	public int updateMember(String userId,String email,String phone,String address,String hobby) {
		int result = 0;
		Connection conn = getConnection();
		
		
		result = md.updateMember(userId,email,phone,address,hobby,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
}
