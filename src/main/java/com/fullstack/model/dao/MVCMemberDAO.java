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
	
	public MVCMemberDAO() {
		try{
			//아래는 JNDI connection 획득 코드입니다
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = source.getConnection();
			System.out.println("커넥션 성공 " + conn);
		}catch(Exception e){
			System.out.println("컨넥션 오류 " + e.getMessage());
		}
	}
	//이 메서드는 컨트롤러에서 호출되어 회원 가입 요청을 한 회원의 정보를 
	//DB에 Insert하는 작업을 합니다
	//결과에 따른 응답은 boolean으로 리턴합니다
	public boolean registerMember(MVCMemberDTO member) {

		try {
		String insertSql = "insert into MVC_MEMBER(num, id, pw, name) "
				+ "values (MVC_SEQ.NEXTVAL,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		}catch (Exception e) {
			System.err.println("회원가입 중 에러 " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
