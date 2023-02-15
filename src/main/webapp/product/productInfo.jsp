<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
	<ul>
		<li>상품코드 : ${product.id }</li>
		<li>메이커 : ${product.name }</li>
		<li>제조사 : ${product.maker }</li>
		<li>가격 : ${product.price }</li>
		<li>제조년월 : ${product.date }</li>
	</ul>
</h2>
</body>
</html>