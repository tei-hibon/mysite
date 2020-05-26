<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴登録</title>
</head>
<body>
 <h2>購入情報登録フォーム</h2>
<form method="POST" action="InsertEmployee" name="myForm" onsubmit="return checkText();">
<table>
		<tr>
			<td>商品ID：</td>
			<td><input type="text" name="item_id" id="item_id" maxlength="20"></td>
		</tr>

		<tr>
			<td>購入者ID：</td>
			<td><input type="text" name="user_id" id="user_id" maxlength="20"></td>
		</tr>

		<tr>
			<td>購入日：</td>
			<td><input type="date" name="perchase_date"></td>
		</tr>
	</table>
	<br>
	<br>
	<input type="submit" value="登録" >

</form>
</body>
</html>