<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入履歴登録</title>
</head>
<body>
 <h2>購入情報登録フォーム</h2>
<form method="POST" action="InputSales_records.jsp" name="InputSales_records" onsubmit="return checkText();">
 <%@ page language="java" import="java.sql.*" %>
<%
   Class.forName("DRIVER_NAME");   //JDBCドライバをロード＆接続先として指定
   Connection myConn = DriverManager.getConnection("jdbc:mysql:///mysql?user=usr&password=pass");
   Statement stmt = myConn.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT items_id, users_id FROM Sales_records");

   while (rs.next()) {
     int i = rs.getInt("items_id");
     int u = rs.getInt("users_id");
     System.out.println(i + " " + u);
  }

   stmt.close();
   myConn.close();
%>

 <p> 商品名：
      <select name="item">
<%
   while (rs.next()) {
     String name = rs.getString("name");   //商品名
     float id = rs.getFloat("id");   //商品ID
  }

%>
</select>
 </p>
 <p> 購入者名：
       <select name="user">
<%
   while (rs.next()) {
     String name = rs.getString("name");
     float id = rs.getFloat("id");
     System.out.println("<option value=" + id +  ">" + name + "</option>" );
     }
%>
</select>
 </p>
 <p>購入日：
    <input type="date" name="perchase_date">
 </p>
	<br>
	<br>
	<input type="submit" value="登録" >

</form>
</body>
</html>