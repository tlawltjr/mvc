<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기결과폼</title>
</head>
<body>
<h2>계산할 값 입력</h2>
<hr>

<form action="CalcController" method="get">
	<input type="text" name="n1" size="10">
	<select name="op">
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" name="n2" size="10">
<input type="submit" value="전송">

</form>
</body>
</html>