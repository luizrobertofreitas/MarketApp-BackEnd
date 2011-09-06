package com.marketbe.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
@XmlRootElement
@SuppressWarnings("serial")
@NamedQueries(value = {
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
})
public class User implements Serializable
{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@NotBlank
	@Column(name="username")
	private String username;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
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
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [getId()=" + getId() + ", getUsername()="
				+ getUsername() + "]";
	}
}
