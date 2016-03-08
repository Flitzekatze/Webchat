package de.bonobo_talk.SpringMVCTest.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.model.Account;
import de.bonobo_talk.SpringMVCTest.model.AccountRole;

 

@Service("AccountDetailsService")
public class AccountDetailsService implements UserDetailsService{
 
    @Autowired
    private AccountService accountService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);
        System.out.println("Account : "+account);
        if(account==null){
            System.out.println("Account not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), 
            		account.getState().equals("Active"), true, true, true, getGrantedAuthorities(account));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(Account account){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(AccountRole accountRole : account.getAccountRoles()){
            System.out.println("AccountRole : "+accountRole);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+accountRole.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}