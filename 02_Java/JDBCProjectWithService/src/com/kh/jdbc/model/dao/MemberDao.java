package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;
import com.kh.jdbc.model.vo.Member;

/*
 * DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
 */
public class MemberDao {

	/*
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메서드 Member m : 사용자가 입력한 값들이 담겨있는 Member객체 insert실행 후
	 * 처리된 행 수 리턴(int)
	 */
	public int insertMember(Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/*
	 * 회원목록을 반환하는 메서드 ArrayList
	 */
	public ArrayList<Member> selectList(Connection conn) {
		// select문(여러행 조회) -> ResultSet -> ArrayList담기
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM MEMBER";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/*
	 * userId를 받아 Member를 삭제하는 sql전달 delete문 -> 처리된 행 수(int) -> 트랜잭션처리
	 */
	public int deleteMember(String userId) {

		return 0;
	}

	/**
	 * Member객체 m을통해서 update sql을 전달하는 메서드
	 */
	public int updateMember(String userId, String email, String phone, String address, String hobby, Connection conn) {
		// update문 -> 처리된 행 수 : int -> 트랜잭션
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE MEMBER SET EMAIL = ? , PHONE = ? , ADDRESS = ? , HOBBY = ? WHERE USERID = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, hobby);
			pstmt.setString(5, userId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectByUserName(String Keyword, Connection conn) {
		// select -> ResultSet -> ArrayList

		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%'";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Keyword);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteMember(String id, Connection conn) {
		int result = 0;
		 
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			result = pstmt.executeUpdate(); 
			

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return result;
	}
}
