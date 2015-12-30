package com.church.visit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.visit.model.User;
import com.church.visit.model.UserCond;
import com.church.visit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return null;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public User login(HttpServletRequest request, User user) {

		User _user = userService.doLogin(user);
		setSessionUser(request, initSessionUser(_user));
		
		return _user;
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public User create(HttpServletRequest request, User user) {
		
		return userService.create(user, getUid(request));
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		removeSession(request, SESSION_KEY);
		return "redirect:/login.htm"; //FIXME
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getOne(HttpServletRequest request,@PathVariable("id") Long id){
		
		return userService.getOne(id);
	}
	
	@RequestMapping( method = RequestMethod.GET)
	@ResponseBody
	public List<User> getList(HttpServletRequest request,HttpServletResponse response,UserCond cond){
		
		return userService.getList(cond);
	}
	
}
