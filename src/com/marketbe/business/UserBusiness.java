package com.marketbe.business;

import com.marketbe.model.entity.User;

/**
 * @author junior
 *
 */
public interface UserBusiness
{
	/**
	 * @param String username
	 * @param String password
	 */
	public User update(User user);
	
	/**
	 * @param username
	 * @return User
	 */
	public User findByUsername(String username);
}
