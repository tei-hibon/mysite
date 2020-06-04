<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>情報分析</title>
<script type="text/javascript">
	 //日にち計算
	function checkDate(){
		var checkDate1 = document.getElementById('purchased_at1').value; //日にち獲得
		var checkDate2 = document.getElementById('purchased_at2').value; //日にち獲得
		var ar1 = checkDate1.split('-');  //日にち１の形を変化 e.g. 2020-01-02 →2020.01.02
		var ar2 = checkDate2.split('-');
		var da1 = new Date(ar1[0], ar1[1], ar1[2]); //日にち再編成
		var da2 = new Date(ar2[0], ar2[1], ar2[2]);
		var diff = da2.getTime() - da1.getTime() ; //日にちを秒（INT型）に変換し計算
		var itemName = document.getElementById('name').value; // アイテムちぇっく
		if(diff < 0){
			alert("Error:正常な日付を入力してください。")
			return false;
		} else {
			if (itemName == ""){
				alert("Error:商品を選んでください")
				return false;
			} else {
				return true;
			}
		}

	}
</script>

</head>
<body>
	<h2>情報分析</h2>

<form method="POST" action="<%=request.getContextPath()%>/Analysis" name="Analysis" onsubmit="return checkDate();">
	<table>
			<tr>
				<td>期間(必須):</td>
				<td >
					<input type="date"  class="date1" name="date1" maxlength="8" size="9" id="purchased_at1"  required>
					 ~  <input type="date" class="date2" name="date2" maxlength="8" size="9" id="purchased_at2" required>


				</td>

			</tr>

			<tr>
				<td>商品名(必須):</td>
				<td><select name="item_name" id="name" style="width:194px " >


				<option value="" style="display: none;">商品名を選択してください。</option>


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

					<input type="checkbox" class="userGender" name="userGender" id="gender1" value="1"><label for="gender1">男性</label>
                   	<input type="checkbox" class="userGender" name="userGender" id="gender2" value="2" ><label for="gender2">女性</label>

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
	<input type="submit" value="入力" onClick="checkDate()">
	<br>
	<br>
	<br><a href="TopPage">トップページへ戻る</a>
</form>

</body>
</html>