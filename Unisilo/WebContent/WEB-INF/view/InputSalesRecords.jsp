<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/InputSalesRecords.js"></script>
<title>購入履歴登録</title>
</head>
<body>
 <h2>購入情報登録</h2>
<form method="POST" action="<%=request.getContextPath()%>/InsertSalesRecords" name="InputSalesRecords" onsubmit="return checkNull();">

 <p> 商品名：
      <select name="itemId">
      <option value="0" style="display: none;">商品名を選択してください</option>
<%
    @SuppressWarnings("unchecked")
	List<Map<String,Object>> items = (List<Map<String,Object>>)request.getAttribute("items");
	for(Map<String,Object> item : items) {
		int id = (int)item.get("id");
		String name = (String)item.get("name");
	    String gender  = (String)item.get("gender");
	    out.println("<option value=" + id +  ">"+ id + ". "+ name + "----" + gender + "</option>" );
	}
%>

</select>
 </p>
 <p> 顧客名：
       <select name="userId">
       <option value="0" style="display: none;">顧客名を選択してください</option>
<%
	@SuppressWarnings("unchecked")
	List<Map<String,Object>> users = (List<Map<String,Object>>)request.getAttribute("users");
	for(Map<String,Object> user : users) {
		int id = (int)user.get("id");
		String name = (String)user.get("name");
	    String gender  = (String)user.get("gender");
	    out.println("<option value=" + id +  ">"+ id + ". "+ name + "----" + gender + "</option>" );
	}
%>
</select>
</p>
 <p>購入日：
    <input type="date" name="purchasedAt">
 </p>
	<br>
	<br>
	<input type="submit" value="登録" >
</form>
</body>
<footer>
    <br>
    <br>
<a href="TopPage">トップページへ戻る</a><br>
</footer>
</html>