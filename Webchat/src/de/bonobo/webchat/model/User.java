package de.bonobo.webchat.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDataFormat;
import java.sql.Date;
import java.util.Set;

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
@Table(name ="User")
public class User 
{
	private Integer id;
	private String username;
	private Date dateOfBirth;
	private String gender;
	private String userPicture;
	private Set<Chatroom> favoriteChatrooms;
	
    public User() 
    {
        
	}
	
    //Konstruktor
	public User(String username) 
    {
		this.username = username;
	}
    
	@Id
	@Column(name="User_ID")
	@GeneratedValue
	public Integer getId() {
	return this.id;
	}
	
	protected void setId(Integer id) 
    {
        this.id = id;
	}
	
	@Column(name="Username")
	public String getUsername() 
    {
        return this.username;
	}
	
	public void setName(String username) 
    {
        this.username = username;
	}

	@Column(name="DateOfBirth")
	public String getDateOfBirth() 
    {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		return df.format(dateOfBirth);
	}

	public void setDateOfBirth(String dateOfBirth) throws ParseException
    {
        DateFormat df = new SimpleDateFormat("dd:MM.yyyy");
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
    
	//@ManyToMany(fetch=FetchType.EAGER, mappedBy="activeUsers")
	public Set<Chatroom> getFavoriteChatrooms() 
    {
        return this.favoriteChatrooms;
	}
	protected void setFavoriteChatrooms(Set<Chatroom> favoriteChatrooms) 
    {
        this.favoriteChatrooms = favoriteChatrooms;
	}

}
