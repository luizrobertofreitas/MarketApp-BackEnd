package com.marketbe.model.dao;

import java.util.List;

import com.marketbe.model.entity.Category;

/**
 * @author junior
 *
 * Database access object for Categories
 */
public interface CategoryDao
{
	/**
	 * @return List<Category>
	 */
	public List<Category> findAllCategories();
	
	/**
	 * @param Integer id
	 * @return Category
	 */
	public Category findById(Integer id);
	
	/**
	 * @param Category category
	 * @return Category
	 */
	public Category createCategory(Category category);
	
	/**
	 * @param Category category
	 */
	public void deleteCategory(Integer id);
	
	/**
	 * @param Category category
	 * @return Category
	 */
	public Category updateCategory(Category category);
}
