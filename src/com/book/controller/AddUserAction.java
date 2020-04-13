package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.User;
import com.book.service.UserService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_user")
public class AddUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取前端传递的数据
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		String reUserPsw = request.getParameter("reUserPsw");
		String userName = request.getParameter("userName");
		String code = request.getParameter("code");
		if(StringUtils.isNullOrEmpty(userId) || StringUtils.isNullOrEmpty(userPsw)
				|| StringUtils.isNullOrEmpty(reUserPsw) 
				|| StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(code)) {
			request.setAttribute("messg", "信息不能为空");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		if(userPsw.equals(reUserPsw)==false) {
			request.setAttribute("messg", "两次输入密码不同");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		// 验证验证码是否相同
		String yzm = request.getSession().getAttribute("yzm").toString();
		if(code.equals(yzm) == false) {
			request.setAttribute("messg", "验证码输入错误");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		// 去除输入信息的两端空格
		userId = userId.trim();
		userPsw = userPsw.trim();
		userName = userName.trim();
		// 根据userId查找对应账户
		User x = userService.findUserById(userId);
		if(x != null) {
			request.setAttribute("messg", "账户已经存在");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		// 把用户信息存入数据库
		User user = new User(userId, userPsw, userName, 1);
		userService.addUser(user);
		request.setAttribute("messg", "添加新用户成功");
		request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
