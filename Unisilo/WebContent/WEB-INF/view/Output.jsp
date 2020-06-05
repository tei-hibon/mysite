<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.Analysis"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果出力</title>
</head>
<body>
<h2>結果出力</h2>
<form method="POST" action="<%=request.getContextPath()%>/Analysis" name="Analysis" >

<table>

	<tr>
		<td>総売上額：</td>
		<td>
			<% out.print(String.format("%,d",request.getAttribute("uriage"))); %>
		</td>
		<td>円</td>
	</tr>

	<tr>
		<td>利益：</td>
		<td>
			<% out.print(String.format("%,d",request.getAttribute("rieki"))); %>
		</td>
		<td>円</td>
	</tr>

</table>







	<br><a href="javascript:window.location = document.referrer;">入力画面に戻る</a>
	<br><a href="TopPage">トップページへ戻る</a>
	</form>
</body>
</html>