<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/inputEmployee.js"></script>
<title>情報分析</title>
</head>
<body>
	<h2>情報分析</h2>

<form method="POST" action="<%=request.getContextPath()%>/Analysis" name="Analysis" onsubmit="return checkText();">
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
				<td><select name="item_name" id="name" style="width:194px ">


				<option value="0" style="display: none;">商品名を選択してください。</option>


					<%
					    @SuppressWarnings("unchecked")
						List<Map<String, Object>> items = (List<Map<String,Object>>)request.getAttribute("items");
							for(Map<String, Object> item : items  ) {
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
				<td>顧客性別：</td>
				<td>

					<input type="checkbox" name="userGender" autocomplete="off" id="gender" value="1"><label for="male">男性</label>
                   	<input type="checkbox" name="userGender" autocomplete="off" id="gender" value="2" ><label for="female">女性</label>

               	</td>
			</tr>
			<tr>
				<td>顧客年齢：</td>
				<td><select name="userAge" id="age" style="width:194px">
				<option value="0" >年齢を選択してください。</option>
				<option value="1" >１０代</option>
				<option value="2" >２０代</option>
				<option value="3" >３０代</option>
				<option value="4" >４０代以上</option>
				</select>
				</td>
			</tr>
	</table>
	<br><br>
	<input type="submit" value="入力">
	<br>
	<br>
	<br><a href="TopPage">トップページへ戻る</a>
</form>

</body>
</html>