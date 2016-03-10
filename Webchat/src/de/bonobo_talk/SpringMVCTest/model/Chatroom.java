package de.bonobo_talk.SpringMVCTest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
<<<<<<< HEAD
import javax.persistence.GenerationType;
=======
>>>>>>> origin/development
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
<<<<<<< HEAD
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CHATROOM")
public class Chatroom 
{
	@Id
	@Column(name = "CHATROOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CHATROOM_SECID")
	private int secId;
	
	@Size(min=3, max=50)
	@Column(name = "CHATROOMNAME", nullable = false)
	private String chatroomname;
	
	@Column(name = "MAXUSER", nullable = false)
	private int maxUser;
	
    @NotEmpty
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;
    
    @ManyToMany(mappedBy = "joinedChatrooms")
    private Set<User> activeUser;
    
    public Chatroom()
    {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChatroomname() {
		return chatroomname;
	}

	public void setChatroomname(String chatroomname) {
		this.chatroomname = chatroomname;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}
	
	public String getSsn() {
		return ssn;
	}

	public Set<User> getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Set<User> activeUser) {
		this.activeUser = activeUser;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Chatroom))
        {
        	return false;
        }
        Chatroom other = (Chatroom) obj;
        if (id != other.id)
        {
        	return false;
        }
        if (ssn == null) 
        {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
        {
        	return false;
        }
        return true;
    }
 
    @Override
    public String toString() {
        return "Chatroom [id=" + id + ", chatroomname=" + chatroomname + ", maxUser="
                + maxUser + "]";
    }
=======

@Entity
@Table(name="Chatroom")
public class Chatroom 
{
	private int id;
	private String chatroomName;
	private int maxUser;
	private Set<User> activeUsers;
	
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
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinTable(	name="Chatroom_User",
				joinColumns={@JoinColumn(name="Chatroom_ID")},
				inverseJoinColumns={@JoinColumn(name="User_ID")}
	)	
	public Set<User> getActiveUsers()
	{
		return this.activeUsers;
	}
	
	public void joinChatroom(User user)
	{
		this.activeUsers.add(user);
	}
	
	public void leaveChatroom(User user)
	{
		this.activeUsers.remove(user);
	}

>>>>>>> origin/development
}
