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
<style>
		body{

			background-image: url("https://data.photo-ac.com/data/thumbnails/c5/c542b5caced8fe3a35157566082c4b20_t.jpeg");
			background-position: center center;
			padding-top:50px;
			font-family: "游ゴシック", "Yu Gothic";
			text-align: center;
		 }


		.left {
			text-align:left;
			heignt: 19px;
		}

		select {
		width: 236px;
	    heignt: 17px;		}

		table{
			margin-left: auto;
			margin-right: auto;
			margin: auto;

		}
		h2{
			border-bottom:2px dotted #800000 ;
			border-top:2px dotted #800000;
			padding-top:15px;
			padding-bottom:10px;
			}


</style>
</head>
<body>
 <h2>購入情報登録</h2>
<form method="POST" action="<%=request.getContextPath()%>/InsertSalesRecords" name="InputSalesRecords" onsubmit="return checkNull();">
<table>
 <tr>
 <td> 商品名(必須)：</td>
      <td class="left"><select name="itemId">
      <option value="" style="display: none;">商品名を選択してください</option>
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
</td>
</tr>


<tr>
 <td> 顧客名(必須)：</td>
       <td class="left"><select name="userId">
       <option value="" style="display: none;">顧客名を選択してください</option>
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
</td>
</tr>

<tr>
<td>購入日(必須)：</td>
   <td class="left"> <input type="date" name="purchasedAt"placeholder="購入日を入力してください">
 </td>
 </tr>

 </table>
	<br>
	<br>
	<input class="left" type="submit" value="登録" height=19>
</form>
</body>
<footer>
    <br>
    <br>
<a href="TopPage">トップページへ戻る</a><br>
</footer>
</html>