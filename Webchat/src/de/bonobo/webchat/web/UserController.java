package de.bonobo.webchat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.bonobo.webchat.dao.UserDAO;
import de.bonobo.webchat.model.User;

@Controller
public class UserController 
{
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("User/List.htm")
	public ModelAndView listUsers() throws Exception
	{
		ModelMap map = new ModelMap();
		map.addAttribute("listOfUsers", userDAO.getAllUsers());
		
		return new ModelAndView("User/List", map);
	}
	 
	@RequestMapping("User/NewUser.htm")
	public ModelAndView newUser() throws Exception
	{
		ModelMap map=new ModelMap();
		
		map.addAttribute("user", new User());
		
		return new ModelAndView("User/NewUser", map);
	}
	 
	@RequestMapping("User/saveNewUser.htm")
	public ModelAndView saveNewUser ( User u) throws Exception
	{
		userDAO.addUser(u);
		return new ModelAndView( "redirect:List.htm");
	}
	
	@RequestMapping("User/Edit.htm")
	public ModelAndView edit(@RequestParam Integer id) 
	{
		ModelMap map=new ModelMap();

		User u=userDAO.getUser(id);
		map.addAttribute("user", u);
		
		return new ModelAndView("User/Edit", map);

	}
	
	@RequestMapping("User/saveEdit.htm")
	public ModelAndView saveEdit( User u) throws Exception 
	{
		userDAO.addUser(u);		
		return new ModelAndView("redirect:List.htm");
	}

}
