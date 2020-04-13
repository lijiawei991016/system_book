package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.pojo.BookInfo;
import com.book.pojo.Category;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/alter_book")
public class AlterBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 声明变量，用于获取前端数据
		String bookName = null, author = null, publisher = null, photo = null;
		Double price = null;
		Integer id = null;
		Category category = null;
		try {
			String realPath = getServletContext().getRealPath("/static/file");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(2 * 1024 * 1024); // 2M
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					if (name.equals("bookName")) {
						if(StringUtils.isNullOrEmpty(value))
							bookName = null;
						else
							bookName = new String(value.getBytes("ISO-8859-1"), "utf-8");
					} else if (name.equals("author")) {
						if(StringUtils.isNullOrEmpty(value))
							author = null;
						else
							author = new String(value.getBytes("ISO-8859-1"), "utf-8");
					} else if (name.equals("categoryId")) {
						category = new Category();
						if(StringUtils.isNullOrEmpty(value)) 
							category.setId(null);
						else 
							category.setId(Integer.valueOf(value));
					} else if (name.equals("price")) {
						if(StringUtils.isNullOrEmpty(value))
							price = null;
						else
							price = Double.valueOf(value);
					} else if(name.equals("id")) {
						if(StringUtils.isNullOrEmpty(value)) {
							request.getRequestDispatcher("/book_mgr").forward(request, response);
							return;
						}
						id = Integer.valueOf(value);
					} else {
						if(StringUtils.isNullOrEmpty(value))
							publisher = null;
						else
							publisher = new String(value.getBytes("ISO-8859-1"), "utf-8");
					}
				} else {
					String fileName = item.getName();
					String contentType = item.getContentType();
					if (contentType.equals("image/png") || contentType.equals("image/jpeg")
							|| contentType.equals("image/gif")) {
						String rand = UUID.randomUUID().toString();
						photo = rand + fileName.substring(fileName.lastIndexOf("."));
						File uploadedFile = new File(realPath, photo);
						item.write(uploadedFile);
					} else {
						photo = null;// 没有上传文件
					}
				}
			}
			// 构造BookInfo对象
			BookInfo book = new BookInfo(id, bookName, author, publisher, price, photo, category);
			// 修改数据库中对应的书籍
			bookService.alterBookById(book);
			// 返回相应数据
			request.setAttribute("message", "修改书籍成功");
			// 根据图书id获取图书信息
			BookInfo result = bookService.findBookById(id);
			// 获取图书分类信息
			List<Category> categories = bookService.listCategories();
			// 把book对象放入request中
			request.setAttribute("book", result);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/jsp/book_edit.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
