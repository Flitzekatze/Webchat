package de.bonobo.webchat.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;



@Entity
	public class User {
	private Integer id;
	private String username;
	private Date dateOfBirth;
	private String gender;
	private String userPicture;
	private Set<Chatroom> favoriteChatrooms;
	public User() {
	}
	//Konstruktor
	public User(String username) {
		this.username = username;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
	return this.id;
	}
	
	protected void setId(Integer id) {
	this.id = id;
	}
	
	public String getUsername() {
	return this.username;
	}
	
	public void setName(String username) {
	this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	@ManyToMany
	public Set<Chatroom> getFavoriteChatrooms() {
	return this.favoriteChatrooms;
	}
	protected void setFavoriteChatrooms(Set<Chatroom> favoriteChatrooms) {
	this.favoriteChatrooms = favoriteChatrooms;
	}
	
	public void addFavoriteChatroom(Chatroom favoriteChatroom) {
	this.favoriteChatrooms.add(favoriteChatroom);
	}
	
	public void removefavoriteChatroom(Chatroom favoriteChatroom) {
	this.favoriteChatrooms.remove(favoriteChatroom);
	}
}
