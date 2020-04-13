package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.BookInfo;
import com.book.pojo.Cart;
import com.book.pojo.User;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/buy")
public class BuyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 验证是否登录账户
		Object userObj = request.getSession().getAttribute("user");
		if(null == userObj) {
			request.setAttribute("message", "登录后才能购买");
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		}
		User user = (User)userObj;
		// 获取书籍id
		String sId = request.getParameter("id");
		if(StringUtils.isNullOrEmpty(sId)) {
			request.setAttribute("message", "书籍编码错误");
			request.getRequestDispatcher("/index").forward(request, response);
			return;
		}
		Integer id = Integer.valueOf(sId);
		// 判断购物车中是否已经存在此商品
		Cart cart = bookService.findCartByBidAndUid(id, user.getUserId());
		if(null == cart) {	// 如果商品不存在，则插入数据库新记录
			BookInfo book = new BookInfo();
			book.setId(id);
			Cart newCart = new Cart(null, book, user, 1);
			bookService.addCart(newCart);
		}
		else {// 如果商品存在
			bookService.alterCart(id, user.getUserId());
		}
		request.setAttribute("message", "成功添加至购物车");
		request.getRequestDispatcher("/index").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
