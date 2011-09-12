package com.marketbe.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marketbe.business.UserBusiness;
import com.marketbe.model.dao.UserDao;
import com.marketbe.model.entity.User;

/**
 * @author junior
 *
 */
@Component
public class UserBusinessImpl implements UserBusiness
{
	@Autowired(required=true)
	private UserDao userDao;
	
	/**
	 * @param UserDao userDao
	 */
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	/**
	 * @return UserDao
	 */
	public UserDao getUserDao()
	{
		return userDao;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.business.UserBusiness#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username)
	{
		return getUserDao().findByUsername(username);
	}
	
	/* (non-Javadoc)
	 * @see com.marketbe.business.UserBusiness#changePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User update(User user)
	{
		return getUserDao().updateUser(user);
	}
}
