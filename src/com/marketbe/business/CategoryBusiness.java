package com.marketbe.business;

import java.util.List;

import com.marketbe.model.entity.Category;

public interface CategoryBusiness
{
	public List<Category> getAllCategories();
	public Category getCategory(Integer id);
	public Category createCategory(Category category);
	public Category updateCategory(Category category);
	public void deleteCategory(Integer id);
}
