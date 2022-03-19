package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;

import com.entity.Product;
import com.entity.Wish;
import com.entity.Wishlist;
import com.repo.WishRepo;
import com.repo.WishlistRepo;
import com.service.ProductServiceimpl;
import com.service.WishServiceimpl;
import com.service.WishlistServiceimpl;

@Controller
public class WishlistController {
	@Autowired
	private WishlistServiceimpl wishlistimpl;
	
	@Autowired
	private WishServiceimpl wishimpl;
	
	@Autowired
	private WishRepo wishrepo;
	
	@Autowired
	private WishlistRepo wishlistrepo;
	
	@Autowired
	private ProductServiceimpl productimpl;
	
//	@GetMapping("/wishlist")
//	public String addwishlist(ModelMap map) {
//		
//		List<Wishlist> wish=wishlistimpl.findWishlist();
//		   map.addAttribute("wishlist",wish);
//		
//		return "wishlist";
//		
//	}
//	@RequestMapping(value ="/wishlist-{id}",method =RequestMethod.GET)
//	public Wish savewishlist(ModelMap map,@PathVariable("id")int id) {
//		
//         String session=RequestContextHolder.currentRequestAttributes().getSessionId();
//         
//         Product product= productimpl.findbyid(id);
//         
//         if(product !=null)
//         {
//        	 wishimpl.addtowish(session, product);
//        	 Wish wish =wishimpl.findbySession(session);
//        	 return wish;
//        	  }
//         
//        return null;
//	
//		//return "redirect:/home";
//	
//	
//	}
	
	@RequestMapping(value ="/wishlist",method =RequestMethod.GET)
	public String showWishlist(ModelMap map) {
		List<Wishlist> wishlist =wishlistimpl.findWishlist();
		
		 Wish wish=wishimpl.findbyid(1);
		 map.put("netamount", wish.getTotalPrice());
		System.out.println(wish.getTotalPrice());
		
		    map.addAttribute("wishlist",wishlist);
		 return "wishlist2"; 
		 
	}
	
	
	@RequestMapping(value ="/wishlist-{id}",method =RequestMethod.GET)
	public String savewishlist(ModelMap map,@PathVariable("id")int id,Wishlist wish,Product product) {
		
          wishlistimpl.addwishlist(id);
          wishimpl.addtotal(wish,product);
	
		return "redirect:/home";
}
	@RequestMapping(value ="/deletewishlist-{id}",method =RequestMethod.GET)
	public String deletewishlist(ModelMap map,@PathVariable("id")int id) {
		
		
		Optional<Wish> wish1=wishrepo.findById((long) 1);
		long A=wish1.get().getId();
		long B=wish1.get().getTotalCount();
		long C=wish1.get().getTotalPrice();
		
		Wish wish =new Wish();
		
		Optional<Wishlist> wishlist= wishlistrepo.findById((long) id);
		wish.setId(1);
		wish.setTotalCount((B-wishlist.get().getProductcount()));
		wish.setTotalPrice((C-wishlist.get().getTotal()));
		wishrepo.save(wish);
		
		wishlistrepo.deleteById((long) id);
		System.out.println("wishlist"+wishlist.get().getTotal());
		System.out.println("wish"+C);
		System.out.println("wishlist"+wishlist.get().getProductcount());
		System.out.println("wish"+B);
	
		return "redirect:/wishlist";
}
	
	@RequestMapping(value ="/wishlist1-{id}",method =RequestMethod.GET)
	public String wishlist1(ModelMap map,@PathVariable("id")int id,Wishlist wish,Product product) {
		
          wishlistimpl.addwishlist(id);
          wishimpl.addtotal(wish,product);
	
		return "redirect:/wishlist";
}
	
	
}