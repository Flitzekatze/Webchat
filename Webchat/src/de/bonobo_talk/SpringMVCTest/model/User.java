package de.bonobo_talk.SpringMVCTest.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="UserTable")
public class User 
{
	private Integer id;
	private String firstname;
	private String lastname; 
	private Date dateOfBirth;
	private String gender;
	private String userPicture;
	private Set<Chatroom> favouriteChatrooms;
	
	public User() 
	{
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="UserID")
	public Integer getId() 
	{
		return this.id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	@Column(name="Firstname")
	public String getFirstname() 
	{
		return this.firstname;
	}
	
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	
	@Column(name="Lastname")
	public String getLastname() 
	{
		return this.lastname;
	}
	
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
	
	@Column(name="DateOfBirth")
	public String getDateOfBirth() 
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		return df.format(dateOfBirth);
	}
	
	public void setDateOfBirth(String dateOfBirth) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		this.dateOfBirth = df.parse(dateOfBirth);
	}
	
	@Column(name="Gender")
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	@Column(name="UserPicture")
	public String getUserPicture() 
	{
		return userPicture;
	}
	
	public void setUserPicture(String userPicture) 
	{
		this.userPicture = userPicture;
	}
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinTable(	name="User_Chatroom",
				joinColumns={@JoinColumn(name="User_ID")},
				inverseJoinColumns={@JoinColumn(name="Chatroom_ID")}
	)	
	public Set<Chatroom> getFavouriteChatrooms() 
	{
		return this.favouriteChatrooms;
	}
	
	protected void setFavouriteChatrooms(Set<Chatroom> favouriteChatrooms) 
	{
		this.favouriteChatrooms = favouriteChatrooms;
	}
	
	public void addFavouriteChatroom(Chatroom chatroom)
	{
		this.favouriteChatrooms.add(chatroom);
	}
	
	public void removeFavouriteChatroom(Chatroom chatroom)
	{
		this.favouriteChatrooms.remove(chatroom);
	}
	
}
