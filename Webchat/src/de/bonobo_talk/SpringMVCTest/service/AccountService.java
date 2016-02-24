package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Account;

public interface AccountService {
	
    Account findById(int id);     
    void saveAccount(Account Account);    
    void updateAccount(Account Account);    
    void deleteAccountBySsn(String ssn); 
    List<Account> getAllAccounts(); 
    Account findAccountBySsn(String ssn);
    boolean isAccountSsnUnique(Integer id, String ssn);
     
}