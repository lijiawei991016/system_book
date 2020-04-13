package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/delete_cart")
public class DeleteCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取cartId
		String sCartId = request.getParameter("cartId");
		if(StringUtils.isNullOrEmpty(sCartId)) {
			request.setAttribute("message", "移除商品失败");
			request.getRequestDispatcher("/cart").forward(request, response);
			return;
		}
		Integer cartId = Integer.valueOf(sCartId);
		// 调用服务，删除掉对应的商品
		int result = bookService.deleteCartById(cartId);
		if(result != 0)
			request.setAttribute("message", "成功移除商品");
		else
			request.setAttribute("message", "移除商品失败");
		request.getRequestDispatcher("/cart").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
