package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.config.Email;
import com.entity.Confirmation;

import com.entity.Product;
import com.entity.Users;
import com.entity.Wish;
import com.entity.paytmdetails;
import com.repo.ConfirmRepo;
import com.repo.WishRepo;
import com.repo.userRepo;
import com.service.ProductServiceimpl;
import com.service.UserServiceImpl;
import com.service.WishlistServiceimpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userimpl;
	
	@Autowired
	private WishlistServiceimpl wishrepo;
	
	@Autowired
	private WishRepo wrepo;
	
	
	
	@Autowired
	private userRepo repo;
	
	@Autowired
	private ConfirmRepo confirmrepo;

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String User(ModelMap map) {
		Users user = new Users();
		map.addAttribute("user", user);
		return "profile/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(Users user) {
		userimpl.register(user);
		System.out.println("its working");
		Email email= new Email();
		String message ="Thanks for registered your account in Our Kabsha Shopping";
		email.sendEmail(user.getGmail(),message);
		
		
		return "redirect:/login";
	}

	// ............................
	@RequestMapping(value ="/login")
	public String loginpage(ModelMap map) 
	{
		return "profile/login";
	}

	 

	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public String logoutpage() {
		wishrepo.DeleteWish();

		Wish wish = new Wish();
		wish.setId(1);
		wish.setTotalPrice(0);
		wish.setTotalCount(0);
		wrepo.save(wish);
		
		
		
		return "redirect:/";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		
//		if(confirm==null) {
//			map.addAttribute("signin",true);
//		}else {
//			map.addAttribute("logout",true);
//		}
		

		return "index";
	}
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "Contact";

	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";

	}

}
