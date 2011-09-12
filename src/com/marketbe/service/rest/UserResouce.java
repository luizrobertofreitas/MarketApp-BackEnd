package com.marketbe.service.rest;

import com.marketbe.service.result.json.impl.UserJSONResult;

/**
 * @author junior
 *
 */
public interface UserResouce
{
	/**
	 * @return String
	 */
	public String ping();
	
	/**
	 * @param username
	 * @param newPassword
	 * @param confirmNewPassword
	 * @return UserJSONResult
	 */
	public UserJSONResult changePassword(String username, String newPassword, String confirmNewPassword);
	
	/**
	 * @param username
	 * @return UserJSONResult
	 */
	public UserJSONResult loadByUsername(String username);
	
	/**
	 * @param username
	 * @param name
	 * @param email
	 * @return UserJSONResult
	 */
	public UserJSONResult updateInformation(String username, String name, String email);
}
