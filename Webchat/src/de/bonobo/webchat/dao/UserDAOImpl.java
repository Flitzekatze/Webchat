package de.bonobo.webchat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo.webchat.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
        this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addUser(User user) 
	{
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
		session.saveOrUpdate(user);		
		session.getTransaction().commit();
	}
	
	@Override
	@Transactional
	public User getUser(Integer id) 
	{
		Session session = sessionFactory.getCurrentSession();
		User retUser;
        session.getTransaction().begin();
        retUser = (User)session.get(User.class, id);
        session.getTransaction().commit();
        return retUser;
        
	}

	@Override
	@Transactional
    public List<User> getByUserName(String username) 
    {
		
		Session session = sessionFactory.getCurrentSession();
		List<User> retList;
        session.getTransaction().begin();
        retList = (List<User>) session.createQuery("from User where username =" + username).list();
        session.getTransaction().commit();
		return retList;
	}

	@Override
	@Transactional
	public void createUser(String username) 
	{
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
		session.saveOrUpdate(new User(username));		
		session.getTransaction().commit();
	}
	
	@Override
	@Transactional
	public void deleteUser(User user) 
	{
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
		session.delete(user);		
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public List<User> getAllUsers() 
	{
		Session session = sessionFactory.getCurrentSession();
		List<User> retList;
        session.getTransaction().begin();
        retList = (List<User>) session.createQuery("from User").list();
        session.getTransaction().commit();
		return retList;
	}
}