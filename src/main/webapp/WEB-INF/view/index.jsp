<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>전완기</title>
<link rel="stylesheet" type="text/css" href="/css/Extension.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<section>
		<h1>전완기 - 플로우 과제(파일 확장자 차단)</h1>
		<section class="Extension-check">
			<b>고정 확장자</b> <input type="checkbox" value="bat" name="extension">bat
			<input type="checkbox" value="cmd" name="extension">cmd 
			<input type="checkbox" value="com" name="extension">com 
			<input type="checkbox" value="cpl" name="extension">cpl 
			<input type="checkbox" value="exe" name="extension">exe 
			<input type="checkbox" value="scr" name="extension">scr 
			<input type="checkbox" value="js" name="extension">js 
			<br> 
			<br>
			<b>커스텀 확장자</b> 
			<input type="text" maxlength="20" class="input-custom" placeholder="확장자 입력" size="20" maxlength="20" required="required"> 
			<input type="button" value="추가" class="add-btn">
			<section class="custom-ex-list">
			<br>
			<c:forEach var="row" items="${value }">
				<span class="custom-ex" data-id="${row.id }">
				&nbsp;${row.extension }&nbsp;<i class="close-icon">X</i>&nbsp;
				&nbsp;</span>
			</c:forEach>
			</section>
			<br>
			커스텀 확장자 수 : <span class="amount"><c:out value="${Count }"/></span>/200  
		</section>
	</section>

</body>
<script src="/script/extensionScript.js"></script>
</html>