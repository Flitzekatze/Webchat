package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Account;
import de.bonobo_talk.SpringMVCTest.model.User;

public interface AccountDAO 
{
	public Account getAccount(Integer id);
	public List<Account> getAllAccounts();
	public void deleteAccount(Account account);
	public void saveOrUpdateAccount(Account account);
	public void addUser(Integer id, User user);
	public void removeUser(Integer id);
}
