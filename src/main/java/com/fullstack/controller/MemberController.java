package com.fullstack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fullstack.model.dao.MVCMemberDAO;
import com.fullstack.model.dto.MVCMemberDTO;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	//요청 파라미터를 전달받습니다
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	
    	MVCMemberDTO dto = new MVCMemberDTO();
    	dto.setId(id);
    	dto.setName(name);
    	dto.setPw(pw);
    	
    	//위 DTO가 Setting되었으나 DAO를 호출하여 DTO를 DB에 Insert합니다
    	//참고로 num필드는 기존 시퀀스값을 이용예정이니 시퀀스 있는지 확인하세요
    	//없으시면 만드시고 있으시면 currval값 찍어보세요
    	
    	MVCMemberDAO dao;
    	
    	
    }

}
