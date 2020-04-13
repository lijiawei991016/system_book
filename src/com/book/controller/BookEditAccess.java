package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.BookInfo;
import com.book.pojo.Category;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/book_edit")
public class BookEditAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收图书参数
		String sId = request.getParameter("id");
		if(StringUtils.isNullOrEmpty(sId)) {
			request.getRequestDispatcher("/WEB-INF/jsp/book_mgr.jsp").forward(request, response);
			return;
		}
		Integer id = Integer.valueOf(sId);
		// 根据图书id获取图书信息
		BookInfo book = bookService.findBookById(id);
		if(book == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/book_mgr.jsp").forward(request, response);
			return;
		}
		// 获取图书分类信息
		List<Category> categories = bookService.listCategories();
		// 把book对象放入request中
		request.setAttribute("book", book);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/WEB-INF/jsp/book_edit.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
