package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

<<<<<<< HEAD
import de.bonobo_talk.SpringMVCTest.model.Chatroom;
=======
>>>>>>> origin/development
import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserService {
	
	User findById(int id);
    void saveUser(User user);  
    void deleteUserByUsername(String username);
    List<User> getAllUser();
    User findUserByUsername(String username);
<<<<<<< HEAD
    void addFavouriteChatroom(int userID, Chatroom chatroom);
    void removeFavouriteChatroom(int userID, Chatroom chatroom);
    void joinChatroom(int userID, Chatroom chatroom);
    void leaveChatroom(int userID, Chatroom chatroom);
=======
>>>>>>> origin/development
     
}