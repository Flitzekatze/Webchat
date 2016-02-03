package de.bonobo.webchat.dao;

import java.util.List;

import de.bonobo.webchat.model.Chatroom;

public interface ChatroomDAO 
{
	public void addNewChatroom(Chatroom chatroom);
	public void createNewChatroom(String chatroomName);
	public void deleteChatroom(Chatroom chatroom);
	public Chatroom getChatroom(int chatroomId);
	public List<Chatroom> getChatroomByName(String chatroomName);
	public List<Chatroom> getAllChatrooms();
}