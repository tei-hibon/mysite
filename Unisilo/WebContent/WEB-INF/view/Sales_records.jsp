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
   Connection myConn = DriverManager.getConnection( "jdbc:mysql://121.142.93.107:20621/unisilodb?characterEncoding=UTF-8&serverTimezone=JST&user=nskensyu2020&password=2020Nskensyu!");
   Statement stmt = myConn.createStatement();
   ResultSet itrs = stmt.executeQuery("SELECT id, name, gender FROM items");

%>

 <p> 商品名：
      <select name="ITEM_ID">
      <option value="0" style="display: none;">商品名を選択してください</option>
<%
   while (itrs.next()) {
	   int iti = itrs.getInt("id");
	    String itn = itrs.getString("name");
	   int itg = itrs.getInt("gender");
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
 </p>
 <p> 顧客名：
       <select name="USER_ID">
       <option value="0" style="display: none;">顧客名を選択してください</option>
<%
   while (usrs.next()) {
	   int usi = usrs.getInt("id");
	    String usn = usrs.getString("name");
	   int usg = usrs.getInt("gender");
	    String USG;
	     if(usg == 1){
	    	 USG = "男性";
	     }else{
	    	 USG = "女性";
	     }
	    out.println("<option value=" + usi +  ">" + usi + ". " + usn + "----" + USG + "</option>" );
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