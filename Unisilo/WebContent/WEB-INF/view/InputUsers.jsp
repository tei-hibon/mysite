<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入者情報入力</title>
</head>
<body>
   <form method="POST" action="InsertUsers" name="myForm" onsubmit="return checkText();">
     <table>

     <tr>
       <td>名前：</td>
       <td><input type="text" name="name" id="name" maxlength="20"></td>
     </tr>

      <tr>
     <td>性別：</td>
			<td>
				<label for="male">男性</label><input type="radio" name="gender" id="male" value="1">
				<label for="female">女性</label><input type="radio" name="gender" id="female" value="2">
			</td>
     </tr>

     <tr>
       <td>年齢：</td>
       <td><input type="text" name="age" id="age"></td>
     </tr>

     </table>

     <br>
     <br>
     <input type="submit" value="入力" >
   </form>
</body>
<footer>
<!- トップのURL入れる-!>
<a href=“https://www/”>トップページに戻る</a><br>
</footer>
</html>