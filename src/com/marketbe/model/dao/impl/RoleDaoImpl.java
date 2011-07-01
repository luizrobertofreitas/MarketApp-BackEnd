package com.marketbe.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marketbe.model.dao.RoleDao;
import com.marketbe.model.entity.Role;

/**
 * @author junior
 * 
 * Implementation for RoleDao interface
 */
@Repository
@Transactional(readOnly=true)
public class RoleDaoImpl implements RoleDao
{
	/**
	 * EntityManager
	 */
	private EntityManager entityManager;
	
	/**
	 * Constructor
	 */
	public RoleDaoImpl(){}
	
	/**
	 * @return EntityManager
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	/**
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	/* (non-Javadoc)
	 * @see com.market.dao.RoleDao#findAllCategories()
	 */
	@Override
	public List<Role> findAllRoles()
	{
		return entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.market.dao.RoleDao#findById(java.lang.Integer)
	 */
	@Override
	public Role findById(Integer id)
	{
		return entityManager.find(Role.class, id);
	}

	/* (non-Javadoc)
	 * @see com.market.dao.RoleDao#createRole(com.market.entity.Role)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Role createRole(Role role)
	{
		try
		{
			entityManager.getTransaction().begin();
			entityManager.persist(role);
			entityManager.getTransaction().commit();
			return role;
		}
		catch(Exception e)
		{
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			entityManager.close();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.market.dao.RoleDao#deleteRole(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public void deleteRole(Integer id)
	{
		try
		{
			entityManager.getTransaction().begin();
			entityManager.remove(findById(id));
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			entityManager.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.market.dao.RoleDao#updateRole(com.market.entity.Role)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public Role updateRole(Role role)
	{
		try
		{
			entityManager.getTransaction().begin();
			entityManager.merge(role);
			entityManager.getTransaction().commit();
			return role;
		}
		catch(Exception e)
		{
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			entityManager.close();
			return null;
		}
	}
}
