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
request.setCharacterEncoding("UTF-8");

//データベースに接続_
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection myConn = DriverManager.getConnection( "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST&user=nskensyu2020&password=2020Nskensyu!");
	Statement stmt = myConn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT id, name, gender FROM items");
%>
	<table>
			<tr>
				<td>期間(必須):</td>
				<td >
					<input type="date"  name="date1" maxlength="8" size="9" id="purchased_at" >
					 ~  <input type="date" name="date2" maxlength="8" size="9" id="purchased_at" >
				</td>
			</tr>
			<tr>
				<td>商品名(必須):</td>
				<td><select name="item_name" id="name" style="width:194px">
				<option value="0" style="display: none;">商品名を選択してください。</option>
<%
   //SQL値読み込み
   while (rs.next()) {
	   int iti = rs.getInt("id");
	    String itn = rs.getString("name");
	   int itg = rs.getInt("gender");
	    String ITG;
	     if(itg == 1){
	    	 ITG = "メンズ";
	     }else{
	    	 ITG = "レディース";
	     }
	     out.println("<option value=" + iti +  ">"+ iti + ". "+ itn + "----" + ITG + "</option>" );
	    }
%>
<% ResultSet usrs = stmt.executeQuery("SELECT id, name, gender FROM users"); %>
				</select>
				</td>
			</tr>
			<tr>
				<td>顧客性別：</td>
				<td>
					<input type="radio" name="userGender" autocomplete="off" id="gender" value="1"checked><label for="male">男性</label>
                   	<input type="radio" name="userGender" autocomplete="off" id="gender" value="2" checked><label for="female">女性</label>
                   	<input type="radio" name="userGender" autocomplete="off" id="gender" value="2" checked><label for="female">全体</label>
               	</td>
			</tr>
			<tr>
				<td>顧客年齢：</td>
				<td><select name="userAge" id="age" style="width:194px">
				<option value="0" style="display: none;">年齢を選択してください。</option>
				<option value="0" style="display: none;">全年齢代</option>
				<option value="0" style="display: none;">１０代</option>
				<option value="0" style="display: none;">２０代</option>
				<option value="0" style="display: none;">３０代</option>
				<option value="0" style="display: none;">４０代以上</option>
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