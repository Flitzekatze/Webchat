package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;


<<<<<<< HEAD

import java.util.Set;

=======
>>>>>>> origin/development
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.UserDAO;
<<<<<<< HEAD
import de.bonobo_talk.SpringMVCTest.model.Chatroom;
=======
>>>>>>> origin/development
import de.bonobo_talk.SpringMVCTest.model.User;
 
 
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO dao;
     
    public User findById(int id) {
        return dao.findById(id);
    }
 
    public void saveUser(User User) {
        dao.saveUser(User);
    }
 
    public void updateUser(User User) {
        User entity = dao.findById(User.getId());
        if(entity!=null){
        	entity.setFirstname(User.getFirstname());
        	entity.setLastname(User.getLastname());
        	entity.setGender(User.getGender());
        	entity.setDateOfBirth(User.getDateOfBirth());
        	entity.setUserpicture(User.getUserpicture());
<<<<<<< HEAD
        	entity.setFavouriteChatrooms(User.getFavouriteChatrooms());
=======
        	entity.setFavoriteChatrooms(User.getFavoriteChatrooms());
>>>>>>> origin/development
        }
    }
 
    public void deleteUserByUsername(String username){
        dao.deleteUserByUsername(username);
    }
     

 
    public List<User> getAllUser() {
    	return dao.getAllUser();
    }
 
    public User findUserByUsername(String username) {
    	return dao.findUserByUsername(username);
    }
<<<<<<< HEAD

	@Override
	public void addFavouriteChatroom(int userID, Chatroom chatroom) {
		// TODO Auto-generated method stub
		User entity = dao.findById(userID);
        if(entity!=null){
        	Set<Chatroom> tmp = entity.getFavouriteChatrooms();
        	tmp.add(chatroom);
        	entity.setFavouriteChatrooms(tmp);
        }
	}
	
	@Override
	public void removeFavouriteChatroom(int userID, Chatroom chatroom) {
		// TODO Auto-generated method stub
		User entity = dao.findById(userID);
        if(entity!=null){
        	Set<Chatroom> tmp = entity.getFavouriteChatrooms();
        	tmp.remove(chatroom);
        	entity.setFavouriteChatrooms(tmp);
        }
	}


	@Override
	public void joinChatroom(int userID, Chatroom chatroom) {
		// TODO Auto-generated method stub
		User entity = dao.findById(userID);
        if(entity!=null){
        	Set<Chatroom> tmp = entity.getJoinedChatrooms();
        	tmp.add(chatroom);
        	entity.setJoinedChatrooms(tmp);
        }
	}

	@Override
	public void leaveChatroom(int userID, Chatroom chatroom) {
		// TODO Auto-generated method stub
		User entity = dao.findById(userID);
        if(entity!=null){
        	Set<Chatroom> tmp = entity.getJoinedChatrooms();
        	tmp.remove(chatroom);
        	entity.setJoinedChatrooms(tmp);
        }
	}
	
=======
 



     
>>>>>>> origin/development
}