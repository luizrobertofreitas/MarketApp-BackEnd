package com.marketbe.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="user_roles")
@XmlRootElement
@SuppressWarnings("serial")
@NamedQueries(value = {
	@NamedQuery(name="UserRoles.findAll", query="SELECT ur FROM UserRoles ur")
})
public class UserRoles implements Serializable
{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="rolename")
	private String rolename;
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getRolename()
	{
		return rolename;
	}
	
	public void setRolename(String rolename)
	{
		this.rolename = rolename;
	}

	@Override
	public String toString()
	{
		return "UserRoles [getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getRolename()=" + getRolename() + "]";
	}
}
