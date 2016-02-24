package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.AccountDAO;
import de.bonobo_talk.SpringMVCTest.model.Account;
 
 
@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {
 
    @Autowired
    private AccountDAO dao;
     
    public Account findById(int id) {
        return dao.findById(id);
    }
 
    public void saveAccount(Account Account) {
        dao.saveAccount(Account);
    }
 
    public void updateAccount(Account Account) {
        Account entity = dao.findById(Account.getId());
        if(entity!=null){
            entity.setUsername(Account.getUsername());
            entity.setPassword(Account.getPassword());
            entity.setEmail(Account.getEmail());
            entity.setSsn(Account.getSsn());
        }
    }
 
    public void deleteAccountBySsn(String ssn) {
        dao.deleteAccountBySsn(ssn);
    }
     
    public List<Account> getAllAccounts() {
        return dao.getAllAccounts();
    }
 
    public Account findAccountBySsn(String ssn) {
        return dao.findAccountBySsn(ssn);
    }
 
    public boolean isAccountSsnUnique(Integer id, String ssn) {
        Account Account = findAccountBySsn(ssn);
        return ( Account == null || ((id != null) && (Account.getId() == id)));
    }


     
}