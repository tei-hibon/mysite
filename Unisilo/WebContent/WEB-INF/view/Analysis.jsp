<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/inputEmployee.js"></script>
<title>Analysis</title>
</head>
<body>
	<h2 style="text-aligh:center;">情報分析</h2>
<form method = "POST" action = "Analysis" name = "Analysis" onsubmit="return check();">
<%
/*request.setCharacterEncoding("UTF-8");

//データベースに接続_ローカルホストに繋がってるので修正必要
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connect = DriverManager.getConnection(
                  "jdbc:mysql://localhost:20621/unisilodb?"+
                  "UTF-8&serverTimezone=JST",
                  "user=nskensyu2020", "password=2020Nskensyu!");
	Statement stmt = connect.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT name, gender FROM items");

	/* SELECT SUM(items.price), SUM(items/price-items.cost)
		FROM sales_records
			JOIN items
				ON sales_records.item_id=items.id
			JOIN users
				ON sales_records.user_id=users.id
			WHERE purchased_at BETWEEN XXXXXXXX and XXXXXXXX
				and items.name='XXX'
				and users.gender=X
				and users.age BETWEEN XX and XXX  */




%>
	<table>
			<tr>
				<td>期間(必須):</td>
				<td>
					<input type="date"  name="date1" maxlength="8" size="8" id="purchased_at">
					~<input type="date" name="date2" maxlength="8" size="8" id="purchased_at">
				</td>
			</tr>
			<tr>
				<td>商品名(必須):</td>
				<td><select name="item_name" id="name">
				<option value="0" style="display: none;">商品名を選択してください。</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>性別：</td>
				<td>
					<input type="radio" name="userGender" autocomplete="off" id="gender" value="1"checked><label for="male">男性</label>
                   	<input type="radio" name="userGender" autocomplete="off" id="gender" value="2" checked><label for="female">女性</label>
               	</td>
			</tr>
			<tr>
				<td>年齢：</td>
				<td><select name="userAge" id="age" >
				<option value="0" style="display: none;">年齢を選択してください。</option>
				</select>
				</td>
			</tr>
	</table>
	<br><br>
	<input type="submit" value="入力">
	<br><a href="リンク先のＵＲＬ">トップページへ戻る</a>
</form>

</body>
</html>