package de.bonobo.webchat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.bonobo.webchat.dao.ChatroomDAO;
import de.bonobo.webchat.model.Chatroom;

@Controller
public class ChatroomController 
{
	@Autowired
	private ChatroomDAO chatroomDAO;
	
	@RequestMapping("Chatroom/List.htm")
	public ModelAndView listChatrooms() throws Exception
	{
		ModelMap map = new ModelMap();
		map.addAttribute("listOfChatrooms", chatroomDAO.getAllChatrooms());
		
		return new ModelAndView("Chatroom/List", map);
	}
	 
	@RequestMapping("Chatroom/NewChatroom.htm")
	public ModelAndView newChatroom() throws Exception
	{
		ModelMap map=new ModelMap();
		
		map.addAttribute("chatroom", new Chatroom());
		
		return new ModelAndView("Chatroom/NewChatroom", map);
	}
	 
	@RequestMapping("Chatroom/saveNewChatroom.htm")
	public ModelAndView saveNewChatroom ( Chatroom c) throws Exception
	{
		chatroomDAO.addNewChatroom(c);
		return new ModelAndView( "redirect:List.htm");
	}
	
	@RequestMapping("Chatroom/Edit.htm")
	public ModelAndView edit(@RequestParam Integer id) 
	{
		ModelMap map=new ModelMap();

		Chatroom c=chatroomDAO.getChatroom(id);
		map.addAttribute("chatroom", c);
		
		return new ModelAndView("Chatroom/Edit", map);

	}
	
	@RequestMapping("Chatroom/saveEdit.htm")
	public ModelAndView saveEdit( Chatroom c) throws Exception 
	{
		chatroomDAO.addNewChatroom(c);		
		return new ModelAndView("redirect:List.htm");
	}

}
