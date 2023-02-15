<%@page import="com.fullstack.model.dto.MVCMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 만약 회원 가입된 사람이 아닌 경우엔 회원폼으로 Redirect 시키도록 위에 정의해보세요 -->
<jsp:useBean id="dto" class="com.fullstack.model.dto.MVCMemberDTO" scope="request">
	<jsp:setProperty property="*" name="dto"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 성공 페이지</title>
</head>
<body>
<h1> 축<%= dto.getId()%>님,</h1>
	컨트롤러 결과 메세지 : ${result }<br>
	${dto.getId() }님 회원가입 축하합니다.
</body>
</html>