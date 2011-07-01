package com.marketbe.model.dao;

import java.util.List;

import com.marketbe.model.entity.Role;

/**
 * @author junior
 * 
 * Database access object for Roles
 */
public interface RoleDao
{
	/**
	 * @return List<Role>
	 */
	public List<Role> findAllRoles();
	
	/**
	 * @param id
	 * @return Role
	 */
	public Role findById(Integer id);
	
	/**
	 * @param role
	 * @return Role
	 */
	public Role createRole(Role role);
	
	/**
	 * @param id
	 * @return List<Role>
	 */
	public void deleteRole(Integer id);
	
	/**
	 * @param role
	 * @return Role
	 */
	public Role updateRole(Role role);
}
