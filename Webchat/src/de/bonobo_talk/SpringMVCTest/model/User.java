package de.bonobo_talk.SpringMVCTest.model;

import java.math.BigDecimal;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="USER")
public class User {
 
    @Id
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
    
    @NotNull
    @Size(min=3, max=50)
    @Column(name = "FAVORITECHATROOMS", nullable = false)
    private String favoriteChatrooms;
     
 
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

	public String getFavoriteChatrooms() {
		return favoriteChatrooms;
	}

	public void setFavoriteChatrooms(String favoriteChatrooms) {
		this.favoriteChatrooms = favoriteChatrooms;
	}

 
    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname="
                + lastname + " , gender=" + gender + ", dateOfBirth="
                + dateOfBirth + ", userpicture="
                + userpicture + ", favoriteChatrooms="
                + favoriteChatrooms + ", gender=" + gender + "]";
    }
     
}

