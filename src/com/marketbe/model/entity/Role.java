package com.marketbe.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="roles")
@SuppressWarnings("serial")
@NamedQueries(value = {
	@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
})
public class Role implements Serializable
{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
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
		return "Role [getId()="
				+ getId() + ", getRolename()=" + getRolename() + "]";
	}
}
