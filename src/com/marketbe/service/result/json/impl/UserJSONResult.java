package com.marketbe.service.result.json.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.marketbe.model.entity.User;
import com.marketbe.service.result.json.JSONResult;

@XmlRootElement
public class UserJSONResult implements JSONResult
{
	private String method;
	private String message;
	private String status;
	private User user;
	private List<User> users;
	
	@Override
	public String getMethod()
	{
		return method;
	}

	@Override
	public void setMethod(String method)
	{
		this.method = method;
	}

	@Override
	public String getStatus()
	{
		return status;
	}

	@Override
	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String getMessage()
	{
		return message;
	}

	@Override
	public void setMessage(String message)
	{
		this.message = message;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}
}
