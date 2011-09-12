package com.marketbe.model.dao;

import java.util.List;

import com.marketbe.model.entity.User;

public interface UserDao
{
	/**
	 * @return List<User>
	 */
	public List<User> findAllUsers();
	
	/**
	 * @param id
	 * @return User
	 */
	public User findById(Integer id);
	
	/**
	 * @param user
	 * @return User
	 */
	public User createUser(User user);
	
	/**
	 * @param id
	 * @return List<User>
	 */
	public void deleteUser(Integer id);
	
	/**
	 * @param user
	 * @return User
	 */
	public User updateUser(User user);
	
	/**
	 * @param username
	 * @return User
	 */
	public User findByUsername(String username);
}
