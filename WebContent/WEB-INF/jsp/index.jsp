<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    	<form id="search-bar" action="index" method="post">
    		书名：<input type="text" class="txt" name="bookName" />
    		<input id="search-btn" type="submit" value=" 搜索图书 " />
    	</form>
    	<div id="main">
    		<!-- left -->
    		<%@ include file="user_include/left.jsp" %>
    		<!-- /left -->
    		<div class="section-right">
    			<div class="box-right">
    				<div class="box-title">您目前浏览的图书【搜索条件——分类：${empty categoryMessage?"全部":categoryMessage }；书名：${empty bookName?"无":bookName }】</div>
    				<p style="color: red;">${message }</p>
    				<div class="paging" style="border-bottom: 1px solid  #64A26F; color: #006666; ">
    					 ${navStr }	
    					 共有图书${count}种，分${countPage}页显示，每页显示${pageSize}个商品
    				</div>
    				<c:forEach items="${books}" var="book">
    				<div class="box-item">
    					<div class="img-box">
    						<c:choose>
    							<c:when test="${empty book.photo }">
    								<img src="${pageContext.request.contextPath}/static/file/xxx.jpg" />
    							</c:when>
    							<c:otherwise>
    								<img src="${pageContext.request.contextPath}/static/file/${book.photo}" />
    							</c:otherwise>
    						</c:choose>
    					</div>
    					<div class="info-box">
    						<span style="font-size: 14px; ">
    						<a href="#id=${book.id}">${book.bookName }</a></span><br />
							作者：${book.author}&nbsp;&nbsp;著<br />
							分类：${book.category.category }<br />
							出版社：${book.publisher }<br />							
							售价：￥<span style="color: #990000;">${book.price }</span>		<br />					
    					</div>
    					<a href="buy?id=${book.id }" class="btn-buy">购&nbsp;&nbsp;买</a>    					
    					<div class="cf"></div>
    				</div>    
  					</c:forEach>				
    				<div class="paging">
    					 ${navStr }				
    				</div>
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