package de.bonobo_talk.SpringMVCTest.DAO;


import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserDAO 
{
	public User getUser(Integer userId);
	public void saveOrUpdateUser(User user);
	public void deleteUser(User user);
	public List<User>getAllUsers();
	public List<User> getByUserName(String username);
	public void addFavouriteChatroom(Integer userId, Chatroom chatroom);
	
}
