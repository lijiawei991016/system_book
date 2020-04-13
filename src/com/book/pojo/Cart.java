package com.book.pojo;

public class Cart {
	private Integer cartId;
	private BookInfo book;
	private User user;
	private Integer count;
	public Cart() {
		super();
	}
	public Cart(Integer cartId, BookInfo book, User user, Integer count) {
		super();
		this.cartId = cartId;
		this.book = book;
		this.user = user;
		this.count = count;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public BookInfo getBook() {
		return book;
	}
	public void setBook(BookInfo book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
