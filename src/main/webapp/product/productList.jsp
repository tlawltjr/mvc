<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품목록</h2>

<hr>
<%
	ArrayList products = (ArrayList)request.getAttribute("products");
	if(products.size() != 0 && products != null){
	
	}
%>
상품목록 객체 : ${products }<br>
<c:forEach var="p" varStatus="i" items="${products }">
	${i.count }<a href="/mvc/pcontrol?action=info&id=${p.id }">
		${p.name } : ${p.price }
	</a>
</c:forEach>
</body>
</html>