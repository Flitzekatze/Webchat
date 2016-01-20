package de.bonobo.webchat.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Chatroom 
{
	private int id;
	private String chatroomName;
	private int maxUser;
	private List<User> listOfActiveUsers;
	
	public Chatroom()
	{
		
	}
	
	public Chatroom(String chatroomName)
	{
		this.chatroomName = chatroomName;
		this.maxUser = 64;
	}
	
	@Id
	@GeneratedValue
	public int getId()
	{
		return this.id;
	}
	
	public String getChatroomName()
	{
		return this.chatroomName;
	}
	
	public int getMaxUser()
	{
		return this.maxUser;
	} 
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setChatroomName(String chatroomName)
	{
		this.chatroomName = chatroomName;
	}
	
	public void setMaxUser(int maxUser)
	{
		this.maxUser = maxUser;
	}
	
	
	//@JoinTable( name = "User_Chatroom", joinColumns = {	@JoinColumn( name = "Chatroom_id" )}, inverseJoinColumns = { @JoinColumn( name = "User_id" )} )
	@ManyToMany
	public List<User> getActiveUsers()
	{
		return this.listOfActiveUsers;
	}
	
	void join(User user)
	{
		this.listOfActiveUsers.add(user);
	}
	
	void leave(User user)
	{
		this.listOfActiveUsers.remove(user);
	}

}