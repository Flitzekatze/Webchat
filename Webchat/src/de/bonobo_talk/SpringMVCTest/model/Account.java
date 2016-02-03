package de.bonobo_talk.SpringMVCTest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Account")
public class Account 
{
	private Integer id;
	private String username;
	private String password;
	private String e_mail;
	private User user;
	private Boolean active;
	
	public Account()
	{
		this.user = new User();
	}
	
	@Id
	@GeneratedValue
	@Column(name="Account_ID")
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	@Column(name="Username")
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	@Column(name="Password")
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	@Column(name="E_Mail")
	public String getE_mail() 
	{
		return e_mail;
	}
	
	public void setE_mail(String e_mail) 
	{
		this.e_mail = e_mail;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public User getUser() 
	{
		return user;
	}
	
	public void setUser(User user) 
	{
		this.user = user;
	}
	
	@Column(name="Active")
	public Boolean getActive() 
	{
		return active;
	}
	
	public void setActive(Boolean active) 
	{
		this.active = active;
	}
}
