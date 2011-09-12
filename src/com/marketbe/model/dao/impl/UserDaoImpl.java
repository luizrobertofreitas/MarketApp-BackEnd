package com.marketbe.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marketbe.model.dao.UserDao;
import com.marketbe.model.entity.User;

/**
 * @author junior
 * 
 * Implementation for UserDao interface
 * 
 */
@Repository
@Transactional(readOnly=true)
public class UserDaoImpl implements UserDao
{
	/**
	 * EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Constructor
	 */
	public UserDaoImpl(){}
	
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
	 * @see com.marketbe.model.dao.UserDao#findAllUsers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers()
	{
		return getEntityManager().createNativeQuery("User.findAll", User.class).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.marketbe.model.dao.UserDao#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer id)
	{
		return getEntityManager().find(User.class, id);
	}

	/* (non-Javadoc)
	 * @see com.marketbe.model.dao.UserDao#createUser(com.marketbe.model.entity.User)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public User createUser(User user)
	{
		getEntityManager().persist(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.model.dao.UserDao#deleteUser(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public void deleteUser(Integer id)
	{
		getEntityManager().remove(findById(id));		
	}

	/* (non-Javadoc)
	 * @see com.marketbe.model.dao.UserDao#updateUser(com.marketbe.model.entity.User)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRES_NEW)
	public User updateUser(User user)
	{
		getEntityManager().merge(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.model.dao.UserDao#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username)
	{
		try
		{
			return getEntityManager().createNamedQuery("User.findByUsername", User.class).setParameter("username", username).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(" >>>>>>>>>>>>>>> " + e.getMessage());
			return null;
		}
	}
}
