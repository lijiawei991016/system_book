<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>智远图书网</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css"/>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="user_include/header.jsp" %>
    	<!-- /header --> 
    	<div id="main">
    		<div class="box" id="register">
    			<div class="title">新用户注册&nbsp;&nbsp;<span style="color: red;">${messg }</span></div>
<form action="add_user" method="post" style="margin: 10px;">
	<table cellspacing="0" class="no-border">
    	<tr>
    		<td style="text-align: right;">登录账号：</td>
    		<td><input type="text" name="userId" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">登录密码：</td>
    		<td><input type="password" name="userPsw" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">再次输入密码：</td>
    		<td><input type="password" name="reUserPsw" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">真实姓名：</td>
    		<td><input type="text" name="userName" class="txt" value="" /></td>
    	</tr>
    	<tr>
    		<td style="text-align: right;">验证码：</td>
    		<td><input type="text" name="code" class="txt" /></td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td><img id="codeImg" 
			src="${pageContext.request.contextPath}/code_img" /><a
			href="javascript:changeImg();" rel="external nofollow">看不清</a><br /></td>
    	</tr>
    	<tr>
    		<td>&nbsp;</td>
    		<td><input type="submit" value=" 注  册 " class="btn" />&nbsp;&nbsp;</td>
    	</tr>
    </table>
</form>
    		</div>
    	</div>  	
		<!-- footer -->	
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
<script type="text/javascript">
   function changeImg(){
     var img = document.getElementById("codeImg");
     img.src="${pageContext.request.contextPath}/code_img?"+new Date().getTime();
   }
   changeImg();
 </script>
  </body>
</html>