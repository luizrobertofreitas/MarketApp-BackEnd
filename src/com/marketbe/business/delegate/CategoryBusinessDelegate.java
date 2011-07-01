package com.marketbe.business.delegate;

import java.util.List;

import com.marketbe.model.dao.CategoryDao;
import com.marketbe.model.entity.Category;

public final class CategoryBusinessDelegate
{
	private static CategoryDao categoryDao;
	
	private CategoryBusinessDelegate(){};
	
	public static List<Category> getAllCategories()
	{
		return categoryDao.findAllCategories();
	}

	public static void setCategoryDao(CategoryDao categoryDao)
	{
		CategoryBusinessDelegate.categoryDao = categoryDao;
	}

	public static CategoryDao getCategoryDao()
	{
		return categoryDao;
	}
}
