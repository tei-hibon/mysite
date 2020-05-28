<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.Sales_recordsDao"      %>
 <%@ page import="model.Sales_recordsDto"      %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴登録</title>
</head>
<body>
 <h2>購入情報登録フォーム</h2>
<form method="POST" action="<%=request.getContextPath()%>/SaveSales_records" name="Sales_records" onsubmit="return checkText();">
<%
   Class.forName("com.mysql.cj.jdbc.Driver");   //JDBCドライバをロード＆接続先として指定
   Connection myConn = DriverManager.getConnection( "jdbc:mysql://localhost/mysql?characterEncoding=UTF-8&serverTimezone=JST",  "root", "infonic5818");
   Statement stmt = myConn.createStatement();
   ResultSet irs = stmt.executeQuery("SELECT id, name FROM items");

%>

 <p> 商品名：
      <select name="ITEM_ID">
      <option value="0" style="display: none;">商品名を選択してください</option>
<%
   while (irs.next()) {
	   int ii = irs.getInt("id");
	     String in = irs.getString("name");
	     out.println("<option value=" + ii +  ">"+ ii + " "+ in +  "</option>" );
	    }
%>

<% ResultSet urs = stmt.executeQuery("SELECT id, name FROM users"); %>

</select>
 </p>
 <p> 購入者名：
       <select name="USER_ID">
       <option value="0" style="display: none;">購入者名を選択してください</option>
<%
   while (urs.next()) {
	   int ui = urs.getInt("id");
	    String un = urs.getString("name");
	    out.println("<option value=" + ui +  ">" + ui + " " + un + "</option>" );
     }
%>
</select>

 <%stmt.close();
 myConn.close();%>

 </p>
 <p>購入日：
    <input type="date" name="PURCHASED_AT">
 </p>
	<br>
	<br>
	<input type="submit" value="登録" >

</form>
</body>
</html>