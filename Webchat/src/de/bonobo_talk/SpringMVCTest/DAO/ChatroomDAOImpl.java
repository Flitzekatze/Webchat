package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

<<<<<<< HEAD
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;

@Repository("ChatroomDAO")
public class ChatroomDAOImpl extends AbstractDao<Integer, Chatroom> implements ChatroomDAO 
{

	@Override
	public Chatroom findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveChatroom(Chatroom chatroom) {
		// TODO Auto-generated method stub
		persist(chatroom);
	}

	@Override
	public void deleteChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
        Query query = getSession().createSQLQuery("delete from Chatroom where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chatroom> getAllChatrooms() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        return (List<Chatroom>) criteria.list();
	}

	@Override
	public Chatroom findChatroomBySsn(String ssn) {
		// TODO Auto-generated method stub
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Chatroom) criteria.uniqueResult();
	}

=======
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
>>>>>>> origin/development
}
