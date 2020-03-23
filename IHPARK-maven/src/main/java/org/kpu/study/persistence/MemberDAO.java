package org.kpu.study.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kpu.study.domain.StudentVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/springdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "x","x");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<StudentVO> readList() {
		connect();
		ArrayList<StudentVO> studentlist = new ArrayList<StudentVO>();
		String sql = "select id,passwd,username,snum,depart,mobile,email from student ";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO student = new StudentVO();
				student.setId(rs.getString("id"));
				student.setPasswd(rs.getString("passwd"));
				student.setUsername(rs.getString("username"));
				student.setSnum(rs.getString("snum"));
				student.setDepart(rs.getString("depart"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));
				
				studentlist.add(student);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return studentlist;
	}
	
	public StudentVO read(String userid) {
		connect();
		StudentVO student = new StudentVO();
		String sql = "select * from student where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				student.setId(rs.getString("id"));
				student.setPasswd(rs.getString("passwd"));
				student.setUsername(rs.getString("username"));
				student.setSnum(rs.getString("snum"));
				student.setDepart(rs.getString("depart"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return student;
	}

}
