package de.bonobo.webchat.dao;


import java.util.List;

import de.bonobo.webchat.model.Chatroom;
import de.bonobo.webchat.model.User;

public interface UserDAO {
	public User getUser(Integer userId);
	public void addUser(User user);
	public void createUser(String userName);
	public void deleteUser(User user);
	public List<User>getAllUsers();
	public List<User> getByUserName(String username);
	
}
