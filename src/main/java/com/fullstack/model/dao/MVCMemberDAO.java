package com.fullstack.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.fullstack.model.dao.MVCMemberDAO;
import com.fullstack.model.dto.MVCMemberDTO;


public class MVCMemberDAO {

private Connection conn;
	
	private static MVCMemberDAO daoInstance = new MVCMemberDAO();
	
	public static MVCMemberDAO getDao() {
		return daoInstance;
	}
	
	private MVCMemberDAO() {
		try{
			//아래는 JNDI connection 획득 코드입니다
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = source.getConnection();
			System.out.println("커넥션 성공" + conn);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public MVCMemberDTO createMem() {
		MVCMemberDTO dto = new MVCMemberDTO();
		try {
		String insertSql = "insert into MVC_MEMBER(num, id, pw) "
				+ "values (MVC_SEQ.NEXTVAL,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		}catch (Exception e) {
			System.err.println("회원가입 중 에러 " + e.getMessage());
			e.setStackTrace(null);
		}
		return dto;
	}
	
	
}
