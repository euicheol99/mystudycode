package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		/*
		int result = 0; // 처리된 행 수 받아줄 변수
		Connection conn = null; // db연결정보 보관 객체
		Statement stmt = null; // sql문을 전달해서 실행 후 결과를 받아올 객체

		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		sc.nextLine();

		String sql = "INSERT INTO TEST VALUES(" + num + ", '" + name + "' ,SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			if(result>0) {
				System.out.println("데이터 삽입 성공");
			}
			else {
				System.out.println("데이터 삽입 실패");
			}
		}*/
		/*
		Connection conn= null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Test>list = new ArrayList<>();
		
		String sql = "SELECT * FROM TEST";
		
		try {
			//1)JDBC Driver등록
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");
		
			//2)Connection생성(url,계정명,비밀번호)
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC","JDBC");
			
			//3)Statement생성
			stmt = conn.createStatement();
			
			//4,5) sql문 전달하면서 결과받기(ResultSet)
			rset = stmt.executeQuery(sql);
			
			//rset.next() => rset의 다음 행이 있는지 없는지를 알려주고 한 행을 내려줍니다.
			while(rset.next()) {
				int tno=rset.getInt("TNO");
				String tname=rset.getString("TNAME");
				Date tdate =rset.getDate("TDATE");
				
				list.add(new Test(tno,tname,tdate));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(list.size()>0) {
			System.out.println(list);
		}
		else {
			System.out.println("데이터가 없습니다.");
		}
		*/
		/*
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.print("수정할 TNO를 입력하세요 : ");
		int tno = sc.nextInt();
		sc.nextLine();
		
		System.out.print("새로운 TNAME을 입력하세요.");
		String newName = sc.nextLine();
		
		System.out.print("새로운 TDATE(YYYY-MM-DD)를 입력하세요 : ");
		String newDate = sc.nextLine();

		//실행할 sql문 작성
//		String sql = "UPDATE TEST SET TNAME = '" + newName + 
//				"', TDATE = TO_DATE('" + newDate + "', 'YYYY-MM-DD') WHERE TNO = " + tno;
		String sql = "UPDATE TEST SET TNAME = ?, TDATE = TO_DATE(?, 'YYYY-MM-DD') WHERE TNO = ?";	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql); //미완성된 sql문 전달해서 pstmt객체 생성
			
			//미완성 sql 완성시키기(파마리터 설정 -> ?갯수만큼)
			pstmt.setString(1, newName);
			pstmt.setString(2, newDate);
			pstmt.setInt(3, tno);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(result > 0) {
			System.out.println(result + "개의 행 UPDATE");
		} else {
			System.out.println("UPDATE 실패");
		}
		*/
	}

}