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

@WebServlet("/index")
public class IndexAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取所有的分类类型
		List<Category> categories = bookService.listCategories();
		// 获取当前页码
		String sCurrentPage = request.getParameter("currentPage");
		if(StringUtils.isNullOrEmpty(sCurrentPage)) {
			sCurrentPage = "1";
		}
		Integer currentPage = Integer.valueOf(sCurrentPage);
		// 获取分类名称
		String category = request.getParameter("category");
		if(StringUtils.isNullOrEmpty(category)) {
			Object oCategory = request.getSession().getAttribute("categoryMessage");
			if(oCategory != null) {
				category = oCategory.toString();
			}
			else {
				category = "全部";
			}
		}
		// 获取搜索书籍名
		String bookName = request.getParameter("bookName");
		if(StringUtils.isNullOrEmpty(bookName)) {
			Object oBookName = request.getSession().getAttribute("bookName");
			if(oBookName != null) {
				bookName = oBookName.toString();
			}
			else {
				bookName = "无";
			}
		}
		// 获取所有书籍信息
		List<BookInfo> books = bookService.listBook(currentPage,category,bookName);
		// 获取书籍数量
		Integer count = bookService.bookCount(category,bookName);
		// 调用服务，生成分页导航字符串
		String navStr = bookService.bookNavStr(currentPage, count,"index");
		// 获取总页数
		Integer countPage = count%bookService.PAGESIZE==0?
				count/bookService.PAGESIZE:count/bookService.PAGESIZE+1;
		// 给request设置属性
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		request.setAttribute("count", count);
		request.setAttribute("countPage",countPage);
		request.setAttribute("pageSize", bookService.PAGESIZE);
		request.setAttribute("navStr", navStr);
		// 设置显示分类名称（放入session中）
		request.getSession().setAttribute("categoryMessage", category);
		// 设置搜索的书籍名称
		request.getSession().setAttribute("bookName", bookName);
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












