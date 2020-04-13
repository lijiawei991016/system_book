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
    		<!-- left -->
    		<%@ include file="user_include/left.jsp" %>
    		<!-- /left -->
    		<div class="section-right">
    			<h3 align="center" style="margin-bottom: 20px; ">您选购的商品如下：</h3>
    			<h3 align="center" style="margin-bottom: 14px; color: red;">${message }</h3>
    			<table  align="center"  cellpadding="0" cellspacing="0">
    				<tr>
    					<td class="header" width="200">书名</td>
    					<td class="header"  width="60">单价</td>
    					<td class="header"  width="60">购物数量</td>
    					<td class="header"  width="60">小计</td>
    					<td class="header" width="60">操作</td>
    				</tr>
    				<c:set var="sum" value="0"/>
    				<c:forEach items="${carts }" var="cart">
    					<c:set var="sum" value="${sum=sum+cart.count*cart.book.price }"/>
    					<tr>
    					<td>《${cart.book.bookName }》</td>
    					<td>￥${cart.book.price }</td>
    					<td>${cart.count } 本</td>
    					<td>￥${cart.count*cart.book.price }</td>
    					<td><a href="delete_cart?cartId=${cart.cartId }">移除</a></td>
    					</tr>
    				</c:forEach>
    				<tr>
    					<td colspan="5" class="header" style="text-align: right;">总计：￥${sum }</td>
    				</tr>
    			</table>	
    			<div style="text-align: center; font-size: 14px; line-height: 40px;">
    				<a href="#" style="text-decoration: underline;">去结账</a>
    			</div>
    		</div>
    		<div class="cf"></div>   	
    	</div>  	
		<!-- footer -->	
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>