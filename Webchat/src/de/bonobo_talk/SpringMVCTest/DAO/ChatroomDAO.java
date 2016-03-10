package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Chatroom;
<<<<<<< HEAD


public interface ChatroomDAO 
{
    Chatroom findById(int id);
    void saveChatroom(Chatroom chatroom);  
    void deleteChatroomBySsn(String ssn);
    List<Chatroom> getAllChatrooms();
    Chatroom findChatroomBySsn(String ssn);
=======
import de.bonobo_talk.SpringMVCTest.model.User;

public interface ChatroomDAO 
{
	public void saveOrUpdateChatroom(Chatroom chatroom);
	public void createNewChatroom(String chatroomName);
	public void deleteChatroom(Chatroom chatroom);
	public Chatroom getChatroom(int chatroomId);
	public List<Chatroom> getChatroomByName(String chatroomName);
	public List<Chatroom> getAllChatrooms();
	public void joinChatroom(Integer chatroomId, User user);
	public void leaveChatroom(Integer chatroomId, User user);
>>>>>>> origin/development
}
