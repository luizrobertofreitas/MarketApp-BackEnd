package com.marketbe.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marketbe.model.dao.CategoryDao;
import com.marketbe.model.entity.Category;

/**
 * @author junior
 * 
 * Implementation class for CategoryDao
 */
@Repository
@Transactional(readOnly=true)
public class CategoryDaoImpl implements CategoryDao
{
	/**
	 * EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor
	 */
	public CategoryDaoImpl(){}
	
	/**
	 * @return EntityManager
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	/**
	 * @param EntityManager entityManager
	 */
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#findAllCategories()
	 */
	@Override
	public List<Category> findAllCategories()
	{
		return entityManager.createNamedQuery("Category.findAll", Category.class).getResultList();		
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#findById(java.lang.Integer)
	 */
	@Override
	public Category findById(Integer id)
	{
		return entityManager.find(Category.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#createCategory(com.market.entity.Category)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Category createCategory(Category category)
	{
		entityManager.persist(category);
		return category;
	}

	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#deleteCategory(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public void deleteCategory(Integer id)
	{
		Category category = entityManager.find(Category.class, id);
		entityManager.remove(category);
	}

	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#updateCategory(com.market.entity.Category)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Category updateCategory(Category category)
	{
		entityManager.merge(category);
		return category;		
	}
}
