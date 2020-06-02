<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ登録</title>
</head>
<body>

	<h2>商品マスタ登録</h2>

	<form method = "POST" action = "InsertItems" name = "InsertItems" onsubmit="return check();">
	<table>
		<tr>
			<td>商品名：</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>性別：</td>
			<td>
				<input type="radio" name="gender" value="1">  男性
				<input type="radio" name="gender" value="2">  女性
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
		<br>
		<input type = "submit" value = "入力">
	</form>

	<br><br>
	<a href="TopPage">トップページへ戻る</a>

	<script type="text/javascript">
	function check() {
		if (InsertItem.name.value == "") { // 「商品名」の入力をチェック
			alert ("エラー：商品名を入力してください")
			return false; // 送信を中止
        } else {
            return true; // 送信を実行
        }
	}
	</script>

</body>
</html>