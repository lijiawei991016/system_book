<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="section-left">
	<div class="box-left">
		<div class="box-title">分类畅销榜</div>
		<div class="box-content">
			<p>
				·<a href="index?category=全部&bookName=无">全部</a>
			</p>
			<c:forEach items="${categories }" var="catg">
				<p>
					·<a href="index?category=${catg.category }&bookName=无">${catg.category}</a>
				</p>
			</c:forEach>
		</div>
	</div>
</div>