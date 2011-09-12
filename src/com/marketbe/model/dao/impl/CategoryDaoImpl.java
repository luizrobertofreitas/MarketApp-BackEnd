package com.marketbe.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		return getEntityManager().createNamedQuery("Category.findAll", Category.class).getResultList();		
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#findById(java.lang.Integer)
	 */
	@Override
	public Category findById(Integer id)
	{
		return getEntityManager().find(Category.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#createCategory(com.market.entity.Category)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Category createCategory(Category category)
	{
		getEntityManager().persist(category);
		return category;
	}

	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#deleteCategory(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public void deleteCategory(Integer id)
	{
		Category category = getEntityManager().find(Category.class, id);
		getEntityManager().remove(category);
	}

	/* (non-Javadoc)
	 * @see com.market.dao.CategoryDao#updateCategory(com.market.entity.Category)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Category updateCategory(Category category)
	{
		getEntityManager().merge(category);
		return category;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategoriesWithPagination(Integer firstPosition, Integer numberOfRecords)
	{
		Query query = getEntityManager().createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(firstPosition);
		query.setMaxResults(numberOfRecords);
		return query.getResultList();
	}
}
