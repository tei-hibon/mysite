<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/inputEmployee.js"></script>
<title>Analysis</title>
</head>
<body>
<div class="container">
	<div class=analysis>
		<h1 style="text-aligh:center;">情報分析</h1>
		<div class="analysisPurchased">
			<table>
				<tr>
					<td>期間(必須):</td>
					<td>
						<input type="text"  name="date1" maxlength="8" size="8" id="purchased_at">
						~<input type="text" name="date2" maxlength="8" size="8" id="purchased_at">
					</td>
				</tr>
			</table>
		</div>

		<div class="analysisName">
			<table>
				<tr>
					<td>商品名(必須):</td>
					<td><select name="item_name" id="name">
						<option>
					</select></td>
				</tr>
			</table>
		</div>


		<div class="analysisGender">
			<table>
				<tr>
					<td>性別：</td>
					<td>
						<input type="radio" name="userGender" autocomplete="off" id="gender" value="1"checked>男性
                     	<input type="radio" name="userGender" autocomplete="off" id="gender" value="2" checked>女性
                   	</td>
				</tr>
			</table>
		</div>

		<div class="analysisAge">
			<table>
				<tr>
					<td>年齢：</td>
					<td><input type="text" name="userAge" size="5"  id="age"></td>
				</tr>
			</table>
		</div>
	</div>
	<input type="submit" value="入力">
</div>
</form>
</body>
</html>