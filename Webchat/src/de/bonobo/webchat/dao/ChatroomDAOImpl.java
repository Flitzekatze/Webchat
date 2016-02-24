package de.bonobo.webchat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo.webchat.model.Chatroom;
import de.bonobo.webchat.model.User;

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
	public void addNewChatroom(Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(chatroom);
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
		session.save(tempChatroom);
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

}