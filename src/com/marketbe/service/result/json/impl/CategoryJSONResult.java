package com.marketbe.service.result.json.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.marketbe.model.entity.Category;
import com.marketbe.service.result.json.JSONResult;

@XmlRootElement
public class CategoryJSONResult implements JSONResult
{
	private String method;
	private String message;
	private String status;
	private Category category;
	private List<Category> categories;
	
	public List<Category> getCategories()
	{
		return categories;
	}
	
	public void setCategories(List<Category> categories)
	{
		this.categories = categories;
	}
	
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
	
	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}
}
