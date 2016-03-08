package de.bonobo_talk.SpringMVCTest.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.bonobo_talk.SpringMVCTest.model.Account;
 

 
@Repository("AccountDAO")
public class AccountDAOImpl extends AbstractDao<Integer, Account> implements AccountDAO {
 
    public Account findById(int id) {
        return getByKey(id);
    }
 
    public void saveAccount(Account Account) {
        persist(Account);
    }
 
    public void deleteAccountBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Account where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        Criteria criteria = createEntityCriteria();
        return (List<Account>) criteria.list();
    }
 
    public Account findAccountBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Account) criteria.uniqueResult();
    }

	@Override
	public Account findAccountByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Account) criteria.uniqueResult();
	}
}
