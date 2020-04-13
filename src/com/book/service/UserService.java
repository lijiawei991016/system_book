package com.book.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.book.dao.UserMapper;
import com.book.pojo.User;
import com.book.tools.MyBatisUtil;

public class UserService {
	/**
	 * 根据账户和密码查询用户
	 * @param userId
	 * @param userPsw
	 * @return 成功返回用户对象，失败返回null
	 */
	public User findUserByIdAndPsw(String userId,String userPsw) {
		// 去除两端空格
		userId = userId.trim();
		userPsw = userPsw.trim();
		// 加密账户和密码
		userId =  DigestUtils.md5Hex(userId);
		userPsw = DigestUtils.md5Hex(userPsw);
		// 调用数据查询
		SqlSession sqlSession = MyBatisUtil.open();
		User result = sqlSession.getMapper(UserMapper.class)
				.findUserByIdAndPsw(userId, userPsw);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
	/**
	 * 根据账户查询账户信息
	 * @param userId
	 * @return 成功返回账户 失败返回null
	 */
	public User findUserById( String userId) {
		// 去除两端空格
		userId = userId.trim();
		// 加密账户和密码
		userId =  DigestUtils.md5Hex(userId);
		// 调用数据查询
		SqlSession sqlSession = MyBatisUtil.open();
		User result = sqlSession.getMapper(UserMapper.class).findUserById(userId);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
	/**
	 * 添加新用户到数据库中
	 * @param user--新用户信息
	 * @return 1-成功 0-失败
	 */
	public int addUser(User user) {
		int result = 0;
		// 加密
		user.setUserId(DigestUtils.md5Hex(user.getUserId()));
		user.setUserPsw(DigestUtils.md5Hex(user.getUserPsw()));
		SqlSession sqlSession = MyBatisUtil.open();
		result = sqlSession.getMapper(UserMapper.class).addUser(user);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
