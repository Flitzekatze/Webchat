package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.User;

public interface UserDAO {
	User findById(int id);
    void saveUser(User user);  
    void deleteUserByUsername(String username);
    List<User> getAllUser();
    User findUserByUsername(String username);
}
 