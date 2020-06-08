<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.Analysis"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果出力</title>
 <link rel="stylesheet" href="htmls/Outputstylesheet.css">
 <style>
		body{

			background-image: url("https://data.photo-ac.com/data/thumbnails/c5/c542b5caced8fe3a35157566082c4b20_t.jpeg");
			background-position: center center;
			padding-top:50px;
			font-family: "游ゴシック", "Yu Gothic";
			text-align: center;
		 }


		table{
			margin-left: auto;
			margin-right: auto;
			margin: auto;

		}

		h2{
			border-bottom:2px dotted #800000 ;
			border-top:2px dotted #800000;
			padding-top:15px;
			padding-bottom:10px;
			}


</style>
</head>
<body>
<h2>結果出力</h2>
<form method="POST" action="<%=request.getContextPath()%>/Analysis" name="Analysis" >


<table>

	<tr>
		<td>
			<% out.println("総売上額：　" + String.format("%,d",request.getAttribute("uriage"))); %>
		</td>
		<td>円</td>
	</tr>

	<tr>
		<td>
			<% out.println("利　　益：　" + String.format("%,d",request.getAttribute("rieki"))); %>
		</td>
		<td>円</td>
	</tr>

</table>

	<br>
	<br><a href="javascript:window.location = document.referrer;">入力画面に戻る</a>
	<br>
	<br><a href="TopPage">トップページへ</a>
	</form>
</body>
</html>