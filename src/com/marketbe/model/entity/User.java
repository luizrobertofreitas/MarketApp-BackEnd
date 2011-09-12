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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.marketbe.util.Constants;

@Entity
@Table(name="users")
@XmlRootElement
@SuppressWarnings("serial")
@NamedQueries(value = {
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByUsername", query="SELECT u FROM User u WHERE u.username = :username")
})
public class User implements Serializable
{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message="Usuário" + Constants.CANNOT_BE_BLANK)
	@Column(name="username")
	private String username;
	
	@Length(min=6, max=10, message="Senha " + Constants.BETWEEN_VALUE + "6 e 10 caracteres")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Nome" + Constants.CANNOT_BE_BLANK)
	@Column(name = "name")
	private String name;
	
	@Email(message="E-mail" + Constants.INVALID)
	@Column(name = "email")
	private String email;
	
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
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "User [getId()=" + getId() + ", getUsername()="
				+ getUsername() + "]";
	}
}
