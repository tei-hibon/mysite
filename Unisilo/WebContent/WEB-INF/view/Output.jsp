<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.Analysis"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>総売上額：</td>
		<td>
			<% out.print(sums.getInt("uriage")); %>
		</td>
		<td>千円</td>
	</tr>

	<tr>
		<td>利益：</td>
		<td>
			<% out.print( rieki); %>
		</td>
		<td>千円</td>
	</tr>

</table>







	<br><a href="javascript:window.location = document.referrer;">入力画面に戻る</a>
	<br><a href="TopPage">トップページへ戻る</a>
</body>
</html>