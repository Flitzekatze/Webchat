package de.bonobo_talk.SpringMVCTest.web;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.bonobo_talk.SpringMVCTest.DAO.AccountDAO;
import de.bonobo_talk.SpringMVCTest.DAO.ChatroomDAO;
import de.bonobo_talk.SpringMVCTest.DAO.UserDAO;
import de.bonobo_talk.SpringMVCTest.model.Account;
import de.bonobo_talk.SpringMVCTest.model.Chatroom;
import de.bonobo_talk.SpringMVCTest.model.User;

@Controller
public class WebchatController 
{
	@Autowired
	private ChatroomDAO chatroomDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping("GenerateTestdata.htm")
	public ModelAndView generateTestdata()
	{
		//Generating some testchatrooms
		Chatroom testRoom1 = new Chatroom("testRoom1");
		Chatroom testRoom2 = new Chatroom("testRoom2");
		testRoom2.setMaxUser(32);
		Chatroom testRoom3 = new Chatroom("testRoom3");
		testRoom3.setMaxUser(128);
		
		//generating some testaccounts
		Account testAccount1 = new Account();
		testAccount1.setUsername("testAccount1");
		testAccount1.setPassword("Satan");
		testAccount1.setE_mail("Peter@bonobo.de");
		
		//generating a testuser (profile for a account)
		testAccount1.getUser().setFirstname("Hans");
		testAccount1.getUser().setLastname("Mueller");
		try 
		{
			testAccount1.getUser().setDateOfBirth("12.12.1212");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		testAccount1.getUser().setGender("male");
		testAccount1.getUser().setUserPicture("uglyPicture.png");
		
		//generating some testaccounts
		Account testAccount2 = new Account();
		testAccount2.setUsername("testAccount2");
		testAccount2.setPassword("Resan");
		testAccount2.setE_mail("General@bonobo.de");
		
		//generating a testuser (profile for a account)	
		testAccount2.getUser().setFirstname("Resum");
		testAccount2.getUser().setLastname("Alkohol");
		try 
		{
			testAccount2.getUser().setDateOfBirth("12.12.1900");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		testAccount2.getUser().setGender("male");
		testAccount2.getUser().setUserPicture("ThePictureOfGod.png");
		
		//generating some testaccounts
		Account testAccount3 = new Account();
		testAccount3.setUsername("testAccount3");
		testAccount3.setPassword("Luzifer");
		testAccount3.setE_mail("Cherubin@bonobo.de");
			
		//generating a testuser (profile for a account)	
		testAccount3.getUser().setFirstname("Perter");
		testAccount3.getUser().setLastname("Zwegert");
		try 
		{
			testAccount3.getUser().setDateOfBirth("6.6.666");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		testAccount3.getUser().setGender("male");
		testAccount3.getUser().setUserPicture("somePicture.png");
		
		
		chatroomDAO.saveOrUpdateChatroom(testRoom1);
		chatroomDAO.saveOrUpdateChatroom(testRoom2);
		chatroomDAO.saveOrUpdateChatroom(testRoom3);
		
		userDAO.saveOrUpdateUser(testAccount1.getUser());
		userDAO.saveOrUpdateUser(testAccount2.getUser());
		userDAO.saveOrUpdateUser(testAccount3.getUser());
		
		accountDAO.saveOrUpdateAccount(testAccount1);
		accountDAO.saveOrUpdateAccount(testAccount2);
		accountDAO.saveOrUpdateAccount(testAccount3);		
		
		chatroomDAO.joinChatroom(testRoom1.getId(), testAccount1.getUser());
		chatroomDAO.joinChatroom(testRoom1.getId(), testAccount2.getUser());
		chatroomDAO.joinChatroom(testRoom1.getId(), testAccount3.getUser());		

		chatroomDAO.joinChatroom(testRoom2.getId(), testAccount2.getUser());
		chatroomDAO.joinChatroom(testRoom2.getId(), testAccount3.getUser());

		chatroomDAO.joinChatroom(testRoom3.getId(), testAccount3.getUser());
		
		userDAO.addFavouriteChatroom(testAccount1.getUser().getId(), testRoom1);
		userDAO.addFavouriteChatroom(testAccount1.getUser().getId(), testRoom2);
		userDAO.addFavouriteChatroom(testAccount1.getUser().getId(), testRoom3);

		userDAO.addFavouriteChatroom(testAccount2.getUser().getId(), testRoom2);
		userDAO.addFavouriteChatroom(testAccount2.getUser().getId(), testRoom3);

		userDAO.addFavouriteChatroom(testAccount3.getUser().getId(), testRoom3);
		
		return new ModelAndView( "redirect:Chatroom/ListChatroom.htm");
	}

/* 
 * ##################################################################################
 * ############################## Chatrooms #########################################
 * ##################################################################################
 */	
	
	@RequestMapping("Chatroom/ListChatroom.htm")
	public ModelAndView listChatrooms() throws Exception
	{
		ModelMap map = new ModelMap();
		map.addAttribute("listOfChatrooms", chatroomDAO.getAllChatrooms());
		
		return new ModelAndView("Chatroom/ListChatroom", map);
	}
	 
	@RequestMapping("Chatroom/NewChatroom.htm")
	public ModelAndView newChatroom() throws Exception
	{
		ModelMap map=new ModelMap();
		
		map.addAttribute("chatroom", new Chatroom());
		
		return new ModelAndView("Chatroom/NewChatroom", map);
	}
	 
	@RequestMapping("Chatroom/saveOrUpdateChatroom.htm")
	public ModelAndView saveOrUpdateChatroom ( Chatroom c) throws Exception
	{
		chatroomDAO.saveOrUpdateChatroom(c);
		return new ModelAndView( "redirect:ListChatroom.htm");
	}
	
	@RequestMapping("Chatroom/EditChatroom.htm")
	public ModelAndView editChatroom(@RequestParam Integer id) 
	{
		ModelMap map=new ModelMap();

		Chatroom c=chatroomDAO.getChatroom(id);
		map.addAttribute("chatroom", c);
		
		return new ModelAndView("Chatroom/EditChatroom", map);

	}

/* 
 * ##################################################################################
 * ################################ Binding #########################################
 * ##################################################################################
 */	
	
	
	@RequestMapping("Binding/JoinChatroom.htm")
	public ModelAndView joinChatroom(@RequestParam Integer id)
	{
		ModelMap map = new ModelMap();
		
		map.addAttribute("user", userDAO.getUser(id));
		map.addAttribute("listOfChatrooms", chatroomDAO.getAllChatrooms());
		
		return new ModelAndView("Chatroom/JoinChatroom", map);
	}
	
/* 
 * ##################################################################################
 * ################################## User ##########################################
 * ##################################################################################
 */		
	
	@RequestMapping("User/ListUser.htm")
	public ModelAndView listUser() throws Exception
	{
		ModelMap map = new ModelMap();
		map.addAttribute("listOfUsers", userDAO.getAllUsers());
		
		return new ModelAndView("User/ListUser", map);
	}
	 
	@RequestMapping("User/NewUser.htm")
	public ModelAndView newUser() throws Exception
	{
		ModelMap map=new ModelMap();
		
		map.addAttribute("user", new User());
		
		return new ModelAndView("User/NewUser", map);
	}
	 
	@RequestMapping("User/saveOrUpdateUser.htm")
	public ModelAndView saveOrUpdateUser ( User u) throws Exception
	{
		userDAO.saveOrUpdateUser(u);
		return new ModelAndView( "redirect:ListUser.htm");
	}
	
	@RequestMapping("User/EditUser.htm")
	public ModelAndView editUser(@RequestParam Integer id) 
	{
		ModelMap map=new ModelMap();

		User u=userDAO.getUser(id);
		map.addAttribute("user", u);
		
		return new ModelAndView("User/EditUser", map);
	}
	
/* 
 * ##################################################################################
 * ################################# Account ########################################
 * ##################################################################################
 */	
	
	@RequestMapping("Account/ListAccount.htm")
	public ModelAndView listAccount()
	{
		ModelMap map = new ModelMap();
		map.addAttribute("listOfAccounts", accountDAO.getAllAccounts());
		return new ModelAndView("Account/ListAccount", map);
	}
	
	@RequestMapping("Account/NewAccount.htm")
	public ModelAndView newAccount() throws Exception
	{
		ModelMap map=new ModelMap();
		
		map.addAttribute("account", new Account());
		
		return new ModelAndView("Account/NewAccount", map);
	}
	 
	@RequestMapping("Account/saveOrUpdateAccount.htm")
	public ModelAndView saveOrUpdateAccount ( Account a) throws Exception
	{
		accountDAO.saveOrUpdateAccount(a);
		return new ModelAndView( "redirect:ListAccount.htm");
	}
	
	@RequestMapping("Account/EditAccount.htm")
	public ModelAndView editAccount(@RequestParam Integer id) 
	{
		ModelMap map=new ModelMap();

		Account a=accountDAO.getAccount(id);
		map.addAttribute("account", a);
		
		return new ModelAndView("Account/EditAccount", map);
	}
}
