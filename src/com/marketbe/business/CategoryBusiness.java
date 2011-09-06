package com.marketbe.business;

import java.util.List;

import com.marketbe.model.entity.Category;

/**
 * @author junior
 *
 */
public interface CategoryBusiness
{
	/**
	 * @return List<Category>
	 */
	public List<Category> getAllCategories();
	
	/**
	 * @param id
	 * @return Category
	 */
	public Category getCategory(Integer id);
	
	/**
	 * @param category
	 * @return Category
	 */
	public Category createCategory(Category category);
	
	/**
	 * @param category
	 * @return Category
	 */
	public Category updateCategory(Category category);
	
	/**
	 * @param id
	 */
	public void deleteCategory(Integer id);
	
	/**
	 * @param firstPosition
	 * @param maxResults
	 * @return List<Category>
	 */
	public List<Category> getAllCategoriesWithPagination(Integer firstPosition, Integer maxResults);
}
