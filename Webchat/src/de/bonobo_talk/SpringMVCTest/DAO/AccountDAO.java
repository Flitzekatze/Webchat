package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import de.bonobo_talk.SpringMVCTest.model.Account;

public interface AccountDAO {
    Account findById(int id);
    void saveAccount(Account Account);  
    void deleteAccountBySsn(String ssn);
    List<Account> getAllAccounts();
    Account findAccountBySsn(String ssn);
}
 