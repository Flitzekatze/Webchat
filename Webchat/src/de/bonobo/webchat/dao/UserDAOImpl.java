package de.bonobo.webchat.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.bonobo.webchat.model.User;

public class UserDAOImpl implements UserDAO {
	
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory); 
		}

	@Override
	public void addUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
		
	}
	
	public User getUser(Integer id) {
	   return(User)hibernateTemplate.get(User.class, id);
	   }

	public List<User> listUser() {
	   return hibernateTemplate.find("from User"); }
	
	public void saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);	
		}

      public List<User> getByUserName(String username) {
		return hibernateTemplate.find("from User where username =" + username);
	}

	public void createUser(String username) {
		hibernateTemplate.save(new User(username));		
	}
	
	public void deleteUser(User user) {
		hibernateTemplate.delete(user);		
	}

	public List<User> getAllUsers() {
		return hibernateTemplate.find("from User");
	}







	
		
}



