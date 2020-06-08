<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/InputUsers.js"></script>
<title>顧客情報登録</title>
<style>
		body{
			background-image: url("https://data.photo-ac.com/data/thumbnails/c5/c542b5caced8fe3a35157566082c4b20_t.jpeg");
			background-position: center center;
			padding-top:50px;
			font-family: "游ゴシック", "Yu Gothic";
			text-align: center;
			list-style: none;
		 }


		table{
			text-align: center;
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
   <h2>顧客情報登録</h2>
   <form method="POST" action="<%=request.getContextPath()%>/InsertUsers" name="myForm" onsubmit="return checkText();">
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
     <input type="submit" value="登録" >
   </form>
   <br><br>
   <a href="TopPage">トップページへ戻る</a><br>
</body>

</html>