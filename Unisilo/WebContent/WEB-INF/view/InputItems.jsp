<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/InputItems.js"></script>
<title>商品マスタ登録</title>
<style>
		body{
			background-image: url("https://data.photo-ac.com/data/thumbnails/c5/c542b5caced8fe3a35157566082c4b20_t.jpeg");
			background-position: center center;
			padding-top:50px;
			font-family: "游ゴシック", "Yu Gothic";
			text-align: center;

		 }

		 .center {
				display:flex;
				justify-content: center;
				outline-color: black;
				outline-style: solid;
				font-size: xx-large;
				font-weight: bold;
				width: fit-content;
				margin-left: auto;
				margin-right: auto;
				padding: 5px;
			}

		table{
			text-align: center;
			margin: auto;
			}

		 h2{
			border-top:2px dotted #800000;
			border-bottom:2px dotted #800000;
			padding-top:15px;
			padding-bottom:15px;
			}


</style>
</head>
<body>

	<h2>商品マスタ登録</h2>

	<form method = "POST" action = "InsertItems" name = "InsertItems" onsubmit="return checkNull();">
	<table>
		<tr>
			<td>商品名：</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>種類：</td>
			<td>
				<input type="radio" name="gender" value="1">  メンズ
				<input type="radio" name="gender" value="2">  レディース
			</td>
		</tr>
		<tr>
			<td>価格：</td>
			<td>
				<input type = "text" name = "price">
			</td>
		</tr>
		<tr>
			<td>原価：</td>
			<td><input type = "text" name = "cost"></td>
		</tr>
	</table>
		<br><br>
		<input type = "submit" value = "登録">
	</form>

	<br><br>
	<a href="TopPage">トップページへ戻る</a>

</body>
</html>