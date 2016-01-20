package de.bonobo.webchat.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.bonobo.webchat.model.Chatroom;

public class ChatroomDAOImpl implements ChatroomDAO 
{
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory( SessionFactory sessionFactory) 
	{
		this.hibernateTemplate = new HibernateTemplate(sessionFactory); 
	}

	@Override
	public void addNewChatroom(Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(chatroom);
	}

	@Override
	public void createNewChatroom(String chatroomName) 
	{
		// TODO Auto-generated method stub
		Chatroom tempChatroom = new Chatroom(chatroomName);
		hibernateTemplate.save(tempChatroom);
	}

	@Override
	public void deleteChatroom(Chatroom chatroom) 
	{
		// TODO Auto-generated method stub
		hibernateTemplate.delete(chatroom);
	}

	@Override
	public Chatroom getChatroom(int chatroomId) 
	{
		// TODO Auto-generated method stub
		return (Chatroom)hibernateTemplate.get(Chatroom.class, chatroomId);
	}

	@Override
	public List<Chatroom> getChatroomByName(String chatroomName) 
	{
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Chatroom where name = " + chatroomName);
	}

	@Override
	public List<Chatroom> getAllChatrooms() 
	{
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Chatroom");
	}

}