package com.fullstack.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fullstack.model.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService service;
	
	//Service 계층에서 활용할 상품과 상품목록의 클래스를 정의합니다
	//이 개념은 상품목록 > 상품의 관계(의존성)을 나타내며, 하나이상의 상품이 상품목록에 포함되어집니다
	//이렇게 구성된 각각의 상품은 목록을 통해 Viewer에게 전달되고 
	//목록내의 각각의 상품에 대한 정보는 상품객체를 통해 표현되어지게 됩니다

	public void init(ServletConfig config) throws ServletException {
		//init()을 오버라이드 할때 보통 super.init(config)를 호출하고 재정의합니다
		super.init(config);
		//이 컨트롤러가 WAS메모리에 로드되는 시점에 service 객체 및 Product객체도 자동 생성되어 메모리에 로드 됩니다
		service = new ProductService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이 메서드에서는 사용자의 요청을 분석해서 요청을 모델이나 View로 분기시키는데 사용됩니다
		//일단 아래는 요청이 없을 경우엔 기본 View action으로 분기시킵니다
		//참고로 action은 쉽게 form tag의 action="요청URL or URI"로 생각하세요
		
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			//요청 URI가 없이 들어올 땐, 보여줄 기본 Viewer로 포워딩시킵니다
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
		}else {
			//위에서 기본 요청이 없을 시에 list로 action 요청을 변경하였으니
			//아래서 다시 요청에 따른 분기를 해줍니다
			switch(action) {
			case "list":
				view = list(request,response);
				break;
			case "info":
				view = info(request,response);
				break;
			}//end switch
			getServletContext().getRequestDispatcher("/product/"+view).forward(request, response);
		}//end if
	}
	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("product", service.find(request.getParameter("id")));
		//view정보 리턴
		return "productInfo.jsp";
	}
	//최종 뷰어를 지정하고 뷰어가 보여줄 데이터를 setting합니다
	private String list(HttpServletRequest request, HttpServletResponse response) {
		//이 뷰어는 생성된 항목 상품을 나열하는데 사용됩니다
		//따라서 모델에서 상품목록을 리턴하는 메서드를 호출하여 세팅하고 영역에 지정합니다
		request.setAttribute("products", service.findAll());
		return "productList.jsp";
	}
	
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}


}
