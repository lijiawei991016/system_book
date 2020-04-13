package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.BookInfo;

public interface BookInfoMapper {
	/**
	 * 添加新书籍到数据库中
	 * @param book
	 * @return 1-成功 0-失败
	 */
	int addNewBook(BookInfo book);
	/**
	 * 查询书籍信息
	 * @param from-起始索引（0开始）
	 * @param pageSize-每页数量
	 * @param category--分类名称
	 * @param bookName--搜索的图书名（模糊查询）
	 * @return 书籍信息列表
	 */
	List<BookInfo> listBook(
			@Param("from") Integer from,@Param("pageSize") Integer pageSize,
			@Param("category") String category,@Param("bookName") String bookName);
	/**
	 * 返回书籍数量
	 * @param category--分类名称
	 * @param bookName--搜索的图书名（模糊查询）
	 * @return
	 */
	Integer bookCount(@Param("category") String category,
			@Param("bookName") String bookName);
	/**
	 * 根据id删除图书
	 * @param id--图书Id
	 * @return 0-失败 1-成功
	 */
	int deleteBookById(Integer id);
	/**
	 * 根据图书id查找对应图书
	 * @param id
	 * @return null-失败  成功返回图书对象
	 */
	BookInfo findBookById(Integer id);
	/**
	 * 根据id修改图书信息
	 * @param book--图书对象
	 * @return 1-成功 0-失败
	 */
	int alterBookById(BookInfo book);
}




