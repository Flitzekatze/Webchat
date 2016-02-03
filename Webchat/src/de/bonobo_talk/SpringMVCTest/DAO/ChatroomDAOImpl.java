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
public class ChatroomDAOImpl implements ChatroomDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
        this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void saveOrUpdateChatroom(Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(chatroom);
        session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void createNewChatroom(String chatroomName) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
		Chatroom tempChatroom = new Chatroom(chatroomName);
		session.saveOrUpdate(tempChatroom);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void deleteChatroom(Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
		session.delete(chatroom);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public Chatroom getChatroom(int chatroomId) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Chatroom retChatroom;
        session.getTransaction().begin();
        retChatroom = (Chatroom)session.get(Chatroom.class, chatroomId);
        session.getTransaction().commit();
		return retChatroom;
	}

	@Override
	@Transactional
	public List<Chatroom> getChatroomByName(String chatroomName) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Chatroom> retList;
        session.getTransaction().begin();
        retList = (List<Chatroom>) session.createQuery("from Chatroom where name = " + chatroomName).list();
        session.getTransaction().commit();
		return retList;
	}

	@Override
	@Transactional
	public List<Chatroom> getAllChatrooms() 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Chatroom> retList;
        session.getTransaction().begin();
        retList =  (List<Chatroom>) session.createQuery("from Chatroom").list();
        session.getTransaction().commit();
		return retList;
	}

	@Override
	@Transactional
	public void joinChatroom(Integer chatroomId, User user) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Chatroom tmpChatroom = (Chatroom)session.get(Chatroom.class, chatroomId);
		tmpChatroom.joinChatroom(user);
		session.save(tmpChatroom);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void leaveChatroom(Integer chatroomId, User user) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Chatroom tmpChatroom = (Chatroom)session.get(Chatroom.class, chatroomId);
		tmpChatroom.leaveChatroom(user);
		session.save(tmpChatroom);
		session.getTransaction().commit();
	}
}
