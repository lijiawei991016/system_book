package com.book.dao;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.User;

public interface UserMapper {
	/**
	 * 根据账户和密码查询账户信息
	 * @param userId
	 * @param userPsw
	 * @return 成功返回账户 失败返回null
	 */
	User findUserByIdAndPsw(
			@Param("userId") String userId,@Param("userPsw") String userPsw);
	/**
	 * 根据账户查询账户信息
	 * @param userId
	 * @return 成功返回账户 失败返回null
	 */
	User findUserById(
			@Param("userId") String userId);
	/**
	 * 添加新用户到数据库中
	 * @param user--新用户信息
	 * @return 1-成功 0-失败
	 */
	int addUser(User user);
}
