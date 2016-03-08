package de.bonobo_talk.SpringMVCTest.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 


import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="ACCOUNT")
public class Account {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "USERNAME", nullable = false)
    private String username;
 
    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @Size(min=3, max=50)
    @Column(name = "EMAIL", nullable = false)
    private String email;
     
    @NotEmpty
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;
    
    @NotEmpty
    @Column(name = "STATE", nullable = false)
    private String state=State.ACTIVE.getState();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ACCOUNT_ACCOUNTROLE", 
             joinColumns = { @JoinColumn(name = "Account_Id") }, 
             inverseJoinColumns = { @JoinColumn(name = "AccountRole_Id") })
    private Set<AccountRole> accountRoles = new HashSet<AccountRole>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    
    public Set<AccountRole> getAccountRoles() {
		return accountRoles;
	}

	public void setAccountRoles(Set<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

	public int getId() {
        return id;
    }
 
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
 
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Account))
            return false;
        Account other = (Account) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Account [id=" + id + ", username=" + username + ", password="
                + password + ", email=" + email + ", ssn=" + ssn + "]";
    }
     
}

