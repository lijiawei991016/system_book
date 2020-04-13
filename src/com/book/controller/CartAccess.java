package com.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.Cart;
import com.book.pojo.Category;
import com.book.pojo.User;
import com.book.service.BookService;

@WebServlet("/cart")
public class CartAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 保存当前用户的购物车中的商品列表
		List<Cart> carts = new ArrayList<>();
		// 获取所有的分类类型
		List<Category> categories = bookService.listCategories();
		// 获取当前用户信息
		Object userObj = request.getSession().getAttribute("user");
		// 如果用户已经登录，则根据用户id获取其购物车中信息
		if(userObj != null) {
			User user = (User)userObj;
			carts = bookService.findCartsByUid(user.getUserId());
		}
		// 给request设置属性
		request.setAttribute("categories", categories);
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
