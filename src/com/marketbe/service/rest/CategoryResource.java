package com.marketbe.service.rest;

import com.marketbe.service.result.json.impl.CategoryJSONResult;

/**
 * @author junior
 * 
 * CategoryResource Interface
 */
public interface CategoryResource
{
	/**
	 * Whether the resource is available or not
	 * 
	 * @return String
	 */
	public String pingResource();
	public CategoryJSONResult getAllCategories();
	public CategoryJSONResult getCategoryById(Integer id);
	public CategoryJSONResult saveCategory(String name, String description);
	public CategoryJSONResult updateCategory(Integer id, String name, String description);
	public CategoryJSONResult deleteCategory(Integer id);
}
