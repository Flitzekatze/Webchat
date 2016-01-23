package de.bonobo.webchat.model;

import java.util.List;

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
@Table(name="Chatroom")
public class Chatroom 
{
	private int id;
	private String chatroomName;
	private int maxUser;
	private Set<User> listOfActiveUsers;
	
	public Chatroom()
	{
		
	}
	
	public Chatroom(String chatroomName)
	{
		this.chatroomName = chatroomName;
		this.maxUser = 64;
	}
	
	@Id
	@Column(name="Chatroom_ID")
	@GeneratedValue
	public int getId()
	{
		return this.id;
	}
	
	@Column(name="ChatroomName")
	public String getChatroomName()
	{
		return this.chatroomName;
	}
	
	@Column(name="MaxUser")
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
	
    public void setActiveUsers(Set<User> activeUsers)
	{
		this.activeUsers = activeUsers;
	}
	
	//@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	//@JoinTable(	name="Chatroom_User",
	//			joinColumns={@JoinColumn(name="Chatroom_ID")},
	//			inverseJoinColumns={@JoinColumn(name="User_ID")}
	public Set<User> getActiveUsers()
	{
		return this.listOfActiveUsers;
	}

}