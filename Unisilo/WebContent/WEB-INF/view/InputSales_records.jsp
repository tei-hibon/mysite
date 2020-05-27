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
   ResultSet irs = stmt.executeQuery("SELECT id, name FROM items");

   while (irs.next()) {
     int ii = irs.getInt("id");
     String in = irs.getString("name");
     System.out.println(ii + " " + in);
  }
   
   ResultSet urs = stmt.executeQuery("SELECT id, name FROM users");

   while (urs.next()) {
     int ui = urs.getInt("id");
     String un = urs.getString("name");
     System.out.println(ui + " " + un);
  }

   stmt.close();
   myConn.close();
%>

 <p> 商品名：
      <select name="item">
<%
   while (irs.next()) {
	   int ii = irs.getInt("id");
	     String in = irs.getString("name");
	     System.out.println(ii + " " + in);
  }

%>
</select>
 </p>
 <p> 購入者名：
       <select name="user">
<%
   while (irs.next()) {
	   int ui = urs.getInt("id");
	    String un = urs.getString("name");
	    System.out.println(ui + " " + un);
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