package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.User;

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
	public void saveOrUpdateUser(User user) 
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

	@Override
	@Transactional
	public void addFavouriteChatroom(Integer userId, Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		User tmpUser = (User)session.get(User.class, userId);
		tmpUser.getFavouriteChatrooms().add(chatroom);
		session.save(tmpUser);
		session.getTransaction().commit();
	}
}
