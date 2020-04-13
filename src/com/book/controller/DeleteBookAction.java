package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/delete_book")
public class DeleteBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取传递的id
		String sId = request.getParameter("id");
		if(StringUtils.isNullOrEmpty(sId)) {
			request.setAttribute("infor", "删除图书失败");
			request.getRequestDispatcher("/book_mgr").forward(request,response);
			return;
		}
		Integer id = Integer.valueOf(sId);
		// 调用服务，删除对应图书
		int result = bookService.deleteBookById(id);
		if(result != 0)
			request.setAttribute("infor", "删除图书成功");
		else
			request.setAttribute("infor", "删除图书失败");
		request.getRequestDispatcher("/book_mgr").forward(request,response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
