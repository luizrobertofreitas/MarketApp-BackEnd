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
	
	/**
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult getAllCategories();
	
	/**
	 * @param firstPosition
	 * @param maxResults
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult getAllCategoriesWithPagination(Integer firstPosition, Integer maxResults);
	
	/**
	 * @param id
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult getCategoryById(Integer id);
	
	/**
	 * @param name
	 * @param description
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult saveCategory(String name, String description);
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult updateCategory(Integer id, String name, String description);
	
	/**
	 * @param id
	 * @return CategoryJSONResult
	 */
	public CategoryJSONResult deleteCategory(Integer id);
}
