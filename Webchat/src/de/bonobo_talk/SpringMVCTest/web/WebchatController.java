package de.bonobo_talk.SpringMVCTest.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import de.bonobo_talk.SpringMVCTest.model.Account;
import de.bonobo_talk.SpringMVCTest.service.AccountService;

@Controller
@RequestMapping("/")
public class WebchatController 
{
		    @Autowired
		    AccountService service;   
		    @Autowired
		    MessageSource messageSource;
		 
		    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
		    public String showStartsite(ModelMap model) {
		 
		        List<Account> Accounts = service.getAllAccounts();
		        model.addAttribute("Accounts", Accounts);
		        return "index";
		    }

		    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
		    public String listAccounts(ModelMap model) {
		 
		        List<Account> Accounts = service.getAllAccounts();
		        model.addAttribute("Accounts", Accounts);
		        return "allAccounts";
		    }
		    

		    @RequestMapping(value = { "/footer" })
		    public String addFooter() {
		 
		        return "footer";
		    }
		    @RequestMapping(value = { "/navigation" })
		    public String addNavigation() {
		 
		        return "navigation";
		    }
		    
		    @RequestMapping(value = { "/popuplogin" } ,method = RequestMethod.GET)
		    public String addPopuplogin(ModelMap model) {
		        Account Account = new Account();
		        model.addAttribute("Account", Account);
		        model.addAttribute("edit", false);
		        return "popuplogin";
		    }

		 
		    
		    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
		    public String newAccount(ModelMap model) {
		        Account Account = new Account();
		        model.addAttribute("Account", Account);
		        model.addAttribute("edit", false);
		        return "registration";
		    }

		    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
		    public String saveAccount(@Valid Account Account, BindingResult result,
		            ModelMap model) {
		 
		        if (result.hasErrors()) {
		            return "registration";
		        }
		 

		        if(!service.isAccountSsnUnique(Account.getId(), Account.getSsn())){
		            FieldError ssnError =new FieldError("Account","ssn",messageSource.getMessage("non.unique.ssn", new String[]{Account.getSsn()}, Locale.getDefault()));
		            result.addError(ssnError);
		            return "registration";
		        }
		         
		        service.saveAccount(Account);
		 
		        model.addAttribute("success", "Account " + Account.getUsername() + " registered successfully");
		        return "success";
		    }
		 
		    @RequestMapping(value = { "/edit-{ssn}-Account" }, method = RequestMethod.GET)
		    public String editAccount(@PathVariable String ssn, ModelMap model) {
		        Account Account = service.findAccountBySsn(ssn);
		        model.addAttribute("Account", Account);
		        model.addAttribute("edit", true);
		        return "registration";
		    }
		     

		    @RequestMapping(value = { "/edit-{ssn}-Account" }, method = RequestMethod.POST)
		    public String updateAccount(@Valid Account Account, BindingResult result,
		            ModelMap model, @PathVariable String ssn) {
		 
		        if (result.hasErrors()) {
		            return "registration";
		        }
		 
		        if(!service.isAccountSsnUnique(Account.getId(), Account.getSsn())){
		            FieldError ssnError =new FieldError("Account","ssn",messageSource.getMessage("non.unique.ssn", new String[]{Account.getSsn()}, Locale.GERMAN));
		            result.addError(ssnError);
		            return "registration";
		        }
		 
		        service.updateAccount(Account);
		 
		        model.addAttribute("success", "Account " + Account.getUsername()  + " updated successfully");
		        return "success";
		    }
		 
		     
		    @RequestMapping(value = { "/delete-{ssn}-Account" }, method = RequestMethod.GET)
		    public String deleteAccount(@PathVariable String ssn) {
		        service.deleteAccountBySsn(ssn);
		        return "redirect:/list";
		    }
		    		 
}
