package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run2 {
	public static void main(String[] args) {
		/*
		int result = 0; // 처리된 행 수 받아줄 변수
		Connection conn = null; // db연결정보 보관 객체
		Statement stmt = null; // sql문을 전달해서 실행 후 결과를 받아올 객체

		Scanner sc = new Scanner(System.in);
		System.out.print("학생 이름 : ");
		String name = sc.next();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.println("학번 : ");
		int studentnum=sc.nextInt();

		String sql = "INSERT INTO STUDENT VALUES(" +"'" +name+"'" + ", " + grade + " ,"+studentnum+")";

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
			
		}
		 */
		int result=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rset=null;
		List<Student> list = new ArrayList<>();
		
		String sqq="SELECT * FROM STUDENT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC","JDBC");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sqq);
			
			while(rset.next()) {
				String name=rset.getString("studentname");
				int grade=rset.getInt("grade");
				int studentnum=rset.getInt("studentnum");
				
				list.add(new Student(name,grade,studentnum));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(list.size()>0) {
			System.out.println(list);
		}
		else {
			System.out.println("데이터가 없습니다.");
		}
		
	}
}
