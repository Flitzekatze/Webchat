package de.bonobo_talk.SpringMVCTest.model;

import java.math.BigDecimal;
 
<<<<<<< HEAD
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
>>>>>>> origin/development
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
<<<<<<< HEAD




=======
>>>>>>> origin/development
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="USER")
public class User {
 
    @Id
<<<<<<< HEAD
    @Column(name = "USER_ID")
=======
>>>>>>> origin/development
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min=3, max=50)
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;
    
    @Size(min=3, max=50)
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;
    
    @Size(min=3, max=50)
    @Column(name = "DATEOFBIRTH", nullable = false)
    private String dateOfBirth;
    
    
    @Column(name = "GENDER", nullable = false)
    private String gender;
    
    @NotNull
    @Size(min=3, max=50)
    @Column(name = "USERPICTURE", nullable = false)
    private String userpicture;
    
<<<<<<< HEAD
    
    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
   	@JoinTable(name = "JOINEDCHATROOMS", joinColumns = { 
   			@JoinColumn(name = "USER_ID", nullable = false, updatable = true) }, 
   			inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID", nullable = false, updatable = true) }
   	)
    private Set<Chatroom> joinedChatrooms;
    
    
    @ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinTable(name = "FAVOURITECHATROOMS", joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "CHATROOM_ID", nullable = false, updatable = true) }
	)
    private Set<Chatroom> favouriteChatrooms;
    
    public User()
    {
    	
    }
=======
    @NotNull
    @Size(min=3, max=50)
    @Column(name = "FAVORITECHATROOMS", nullable = false)
    private String favoriteChatrooms;
>>>>>>> origin/development
     
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

 
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserpicture() {
		return userpicture;
	}

	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}

<<<<<<< HEAD
 
    public Set<Chatroom> getJoinedChatrooms() {
		return joinedChatrooms;
	}


	public void setJoinedChatrooms(Set<Chatroom> joinedChatrooms) {
		this.joinedChatrooms = joinedChatrooms;
	}


	public Set<Chatroom> getFavouriteChatrooms() {
		return favouriteChatrooms;
	}


	public void setFavouriteChatrooms(Set<Chatroom> favouriteChatrooms) {
		this.favouriteChatrooms = favouriteChatrooms;
	}


	@Override
=======
	public String getFavoriteChatrooms() {
		return favoriteChatrooms;
	}

	public void setFavoriteChatrooms(String favoriteChatrooms) {
		this.favoriteChatrooms = favoriteChatrooms;
	}

 
    @Override
>>>>>>> origin/development
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname="
                + lastname + " , gender=" + gender + ", dateOfBirth="
                + dateOfBirth + ", userpicture="
                + userpicture + ", favoriteChatrooms="
<<<<<<< HEAD
                + favouriteChatrooms.toString() + ", gender=" + gender + "]";
=======
                + favoriteChatrooms + ", gender=" + gender + "]";
>>>>>>> origin/development
    }
     
}

