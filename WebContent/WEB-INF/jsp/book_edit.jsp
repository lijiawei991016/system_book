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
				<h2>编辑图书信息</h2>
				<p style="color: red;">${message }</p>
				<form action="alter_book" method="post" enctype="multipart/form-data">
					<input type="hidden" name="id" value="${book.id }" />
					<p>图书书名：<input type="text" name="bookName" value="${book.bookName }"  /></p>
					<p>图书作者：<input type="text" name="author" value="${book.author }"  /></p>
					<p>图书分类：
						<select name="categoryId">	
							<c:forEach items="${categories }" var="catg">
								<c:choose>
									<c:when test="${book.category.id == catg.id }">
										<option value="${catg.id }" selected="selected">${catg.category }</option>
									</c:when>
									<c:otherwise>
										<option value="${catg.id }">${catg.category }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>								
						</select>
					</p>
					<p>图书售价：<input type="number" name="price" value="${book.price }" step="0.01" /></p>
					<p>图书出版社：<input type="text" name="publisher" value="${book.publisher }"  /></p>  
					<c:choose>
						<c:when test="${!empty book.photo }">
							<p>当前图片：<img id="preview" src="${pageContext.request.contextPath}/static/file/${book.photo}"/></p>
						</c:when>
						<c:otherwise>
							<p>当前图片：<img id="preview" src="" style="display: none;"/></p>
						</c:otherwise>
					</c:choose>
					<p>图书图片：<input type="file" name="photo" onchange="viewImage(this)" value="${book.photo }" /></p>   				 				
					<p><input type="submit" value=" 修 改 "  />&nbsp;</p>					
				</form>
			</div>
			<div class="section-right"></div>			
			<div class="cf"></div>
		</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>
