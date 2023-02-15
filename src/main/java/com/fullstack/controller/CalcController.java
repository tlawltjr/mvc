package com.fullstack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet(description = "계산기컨트롤러", urlPatterns = { "/CalcController", "/calcForm" })
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아래의 코드는 클라이언트가 요청한 contextPath
		String contextPath = request.getContextPath();
		//아래는 URI만 리턴하는 메서드
		String uri = request.getRequestURI();
		//System.out.println(contextPath);
		//System.out.println(request.getRequestURI());
		
		uri = uri.substring(uri.indexOf(contextPath) + contextPath.length(), uri.length());
		System.out.println(uri);
		
		if(uri.equals("/calcForm")) {
			getServletContext().getRequestDispatcher("/calcForm.jsp").forward(request, response);
		}else {
			System.out.println(uri);
		
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		//결과값 변수 선언
		long result = 0;
		
		char yon = request.getParameter("op").charAt(0);
		//연산자 파라미터가 기본 문자열이니 이걸 캐릭터로 switch 구문에 적용함
		switch (yon) {
		case '+': {
			result = n1 + n2;
			break;
		}
		case '-': {
			result = n1 - n2;
			break;
		}
		case '*': {
			result = n1 * n2;
			break;
		}
		case '/': {
			result = n1 / n2;
			break;
		}
	
		}
		//먼저 연산된 결과를 영역 객체에 세팅합니다
		//지금은 하나의 요청(request)단위로 설정예정입니다
		request.setAttribute("result", result);
		
		//사용자의 요청정보를 그대로 Viewer 까지 연결을 합니다
		//이때 요청정보는 request정보에 그대로 담겨있기 때문에 
		//이 객체와 response를 같이 넘깁니다
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/calcResult.jsp");
		rd.forward(request, response); //요청 전달 완료
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
