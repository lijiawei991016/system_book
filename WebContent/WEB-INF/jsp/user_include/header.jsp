<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
		<div id="header">
    		<div id="tool-bar">&nbsp;&nbsp; 欢迎光临智远图书网，
    		<c:choose>
    			<c:when test="${empty user }">
    				[<a href="${pageContext.request.contextPath}/login">请登录</a>]&nbsp;
    				[<a href="user_regist">免费注册</a>]&nbsp;&nbsp;&nbsp;
    			</c:when>
    			<c:otherwise>
    				[<a>${user.userName }</a>]&nbsp;
    				[<a href="${pageContext.request.contextPath}/login_out">登出</a>]&nbsp;&nbsp;&nbsp;
    			</c:otherwise>
    		</c:choose>
    		<a href="index">首页</a>&nbsp;|&nbsp;
    		<a href="cart">购物车</a>&nbsp;|&nbsp;
    		<a href="#">我的订单</a>&nbsp;|&nbsp;<a href="#">帮助</a></div>
    		<h1>智远图书网-<span style="font-size: 48px; font-family: Arial; font-weight: lighter;">Book</span></h1>
    	</div>