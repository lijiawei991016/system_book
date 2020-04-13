<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="admin_include/header.jsp" %>
    	<!-- /header -->
    	<div id="main">
			<div class="section-left">    	
				<h2>图书信息列表</h2>	
				<p style="color: red;">${infor }</p>	
				<table class="table" cellspacing="0" style="font-size: 12px;">
			    	<tr>
			    		<td class="header" width="100">书名</td>
			    		<td class="header" width="60">作者</td>
			    		<td class="header" width="60">类型</td>
			    		<td class="header" width="60">售价</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>
			    	<!-- 获取book的categorys属性，再获取category的category -->
			    	<c:forEach items="${books }" var="book">
			    	<tr>
			    		<td>${book.bookName }</td>
			    		<td>${book.author }</td>
			    		<td>${book.category.category }</td>	
			    		<td>${book.price }</td>
			    		<td><a href="delete_book?id=${book.id }">删除</a>&nbsp;<a href="book_edit?id=${book.id }">编辑</a></td>
			    	</tr>
			    	</c:forEach>
			    </table>
			    <div class="paging">
    				${navStr }   					
    			</div>
			</div>
			<div class="section-right">
				<h2>添加图书信息</h2>
				<p style="color:red;">${message }</p>
				<form action="${pageContext.request.contextPath}/add_book" method="post" enctype="multipart/form-data">
					<p>图书书名：<input type="text" name="bookName"  /></p>
					<p>图书作者：<input type="text" name="author"  /></p>
					<p>图书分类：
						<select name="categoryId">
							<c:forEach items="${categories }" var="catg">
							<option value="${catg.id }">${catg.category }</option>
							</c:forEach> 
						</select>
					</p>
					<p>图书售价：<input type="number" name="price" step="0.01" /></p>
					<p>图书出版社：<input type="text" name="publisher"  /></p>   
					<p><img style="display:none;" id="preview"/></p>
					<p>图书图片：<input type="file" name="photo" onchange="viewImage(this)"  /></p>    				 				
					<p><input type="submit" value=" 保 存 "  /></p>
				</form>
			</div>			
			<div class="cf"></div>
		</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>
