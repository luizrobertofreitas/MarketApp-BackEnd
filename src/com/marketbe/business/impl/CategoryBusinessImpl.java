package com.marketbe.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marketbe.business.CategoryBusiness;
import com.marketbe.model.dao.CategoryDao;
import com.marketbe.model.entity.Category;

/**
 * @author junior
 *
 */
@Component
public class CategoryBusinessImpl implements CategoryBusiness
{
	@Autowired(required=true)
	private CategoryDao categoryDao;
	
	/* (non-Javadoc)
	 * @see com.marketbe.business.CategoryBusiness#getAllCategories()
	 */
	public List<Category> getAllCategories()
	{
		if(categoryDao != null)
		{
			return categoryDao.findAllCategories();
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.business.CategoryBusiness#getCategory(java.lang.Integer)
	 */
	@Override
	public Category getCategory(Integer id)
	{
		if(categoryDao != null)
		{
			return categoryDao.findById(id);
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.marketbe.business.CategoryBusiness#createCategory(com.marketbe.model.entity.Category)
	 */
	@Override
	public Category createCategory(Category category)
	{
		if(categoryDao != null)
		{
			categoryDao.createCategory(category);
			return category;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.business.CategoryBusiness#updateCategory(com.marketbe.model.entity.Category)
	 */
	@Override
	public Category updateCategory(Category category)
	{
		if(categoryDao != null)
		{
			categoryDao.updateCategory(category);
			return category;
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.business.CategoryBusiness#deleteCategory(java.lang.Integer)
	 */
	@Override
	public void deleteCategory(Integer id)
	{
		if(categoryDao != null)
		{
			categoryDao.deleteCategory(id);
		}
	}
	
	/**
	 * @param CategoryDao categoryDao
	 */
	public void setCategoryDao(CategoryDao categoryDao)
	{
		this.categoryDao = categoryDao;
	}

	/**
	 * @return CategoryDao
	 */
	public CategoryDao getCategoryDao()
	{
		return categoryDao;
	}
}
