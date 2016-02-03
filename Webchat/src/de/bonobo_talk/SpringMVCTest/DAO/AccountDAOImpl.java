package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.model.Account;
import de.bonobo_talk.SpringMVCTest.model.User;

@Repository
public class AccountDAOImpl implements AccountDAO 
{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
        this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Account getAccount(Integer id) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Account retAccount;
        session.getTransaction().begin();
        retAccount = (Account)session.get(Account.class, id);
        session.getTransaction().commit();
        return retAccount;
	}

	@Override
	@Transactional
	public List<Account> getAllAccounts() 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Account> retList;
        session.getTransaction().begin();
        retList = (List<Account>) session.createQuery("from Account").list();
        session.getTransaction().commit();
		return retList;
	}

	@Override
	@Transactional
	public void deleteAccount(Account account) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.delete(account);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void saveOrUpdateAccount(Account account) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.saveOrUpdate(account);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void addUser(Integer id, User user) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Account tmpAccount = (Account)session.get(Account.class, id);
		tmpAccount.setUser(user);
		session.saveOrUpdate(tmpAccount);
		session.getTransaction().commit();
	}

	@Override
	@Transactional
	public void removeUser(Integer id) 
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Account tmpAccount = (Account)session.get(Account.class, id);
		tmpAccount.setUser(null);
		session.saveOrUpdate(tmpAccount);
		session.getTransaction().commit();
	}

}
