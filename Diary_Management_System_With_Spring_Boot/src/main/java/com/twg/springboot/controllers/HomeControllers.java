package com.twg.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.twg.springboot.entities.Entry;
import com.twg.springboot.entities.User;
import com.twg.springboot.services.EntryService;
import com.twg.springboot.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeControllers {
	@Autowired
	private UserService userService;
	@Autowired
	private EntryService entryService;
	public EntryService getEntryService() {
		return entryService;
	}
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/")
	public String getRoot() {
		return "login";
	}
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	@GetMapping("register")
	public String getRegister() {
		return "register";
	}
	@PostMapping("saveuser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		userService.save(user);
		return "login";
	}
	@PostMapping("homepage")
	public String homePage(@RequestParam String username , @RequestParam String password, Model model,HttpSession session) {
		User user=userService.findByUsername(username);
		String viewname=null;
		if(user==null) {
			viewname="error";
			model.addAttribute("error","user does not exist");
			return viewname;
		}
		else if(!user.getPassword().equals(password)) {
			viewname="error";
			model.addAttribute("error","password incorrect");
			return viewname;
		}
		else {
			viewname="home";
			model.addAttribute("user",user);
			model.addAttribute("username",username);
			session.setAttribute("user", user);
			List<Entry> entries=null;
			try {
				entries=entryService.findByUserId(user.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("entriesList",entries);
			return viewname;
		}	
	}
	@GetMapping("addentry")
	public String addEntry(Model model, HttpSession session) {
		User user=(User) session.getAttribute("user");
		return "addentry";
	}
	@PostMapping("saveentry")
	public String saveEntry(@ModelAttribute("entry") Entry entry, Model model, HttpSession session) {
		entryService.save(entry);
		List<Entry> entries=null;
		User user=(User) session.getAttribute("user");
		try {
			entries=entryService.findByUserId(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("entriesList",entries);
		return "home";
	}
	@GetMapping("home")
	public String back(HttpSession session, Model model) {
		User user=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryService.findByUserId(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("entriesList",entries);
		
		return "home";
	}
	@GetMapping("view")
	public String view(@RequestParam long id,Model model) {
		Entry entry=entryService.findById(id);
		model.addAttribute("entry",entry);
		return "view";
	}
	@GetMapping("update")
	public String update(@RequestParam long id, Model model, HttpSession session) {
		Entry entry=entryService.findById(id);
		model.addAttribute("entry",entry);
		User user=(User)session.getAttribute("user");
		String viewname=null;
		if(user==null) {
			viewname="login";
		}
		else {
			viewname="update";
		}
		return viewname;
		
		
	}
	@PostMapping("save")
	public String save(@ModelAttribute("entry") Entry entry, Model model, HttpSession session) {
		entryService.update(entry);
		User user=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryService.findByUserId(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("entriesList",entries);
		
		return "home";
	}
	@GetMapping("delete")
	public String delete(@RequestParam long id, Model model, HttpSession session) {
		Entry entry=entryService.findById(id);
		entryService.delete(entry);
		User user=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryService.findByUserId(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("entriesList",entries);
		return "home";

	}
	@GetMapping("signout")
	public String signout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
