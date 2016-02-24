package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.UserDAO;
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
        	entity.setFavoriteChatrooms(User.getFavoriteChatrooms());
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
 



     
}