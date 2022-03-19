package com.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.config.Email;
import com.entity.Admin;
import com.entity.Product;
import com.entity.Users;
import com.entity.Wishlist;
import com.repo.Adminrepo;
import com.repo.ProductsRepo;
import com.repo.userRepo;
import com.service.AdminServiceImpl;
import com.service.ProductServiceimpl;
import com.service.UserServiceImpl;



@Controller
public class AdminController {
	@Autowired
	private Adminrepo adminrepo;
	
	@Autowired
	private AdminServiceImpl adminservice;
	
	@Autowired
	private ProductsRepo productrepo;
	@Autowired
	private ProductServiceimpl productimpl;
	
	@Autowired
	private UserServiceImpl userimpl;
	
	
	@Autowired
	private userRepo userrepo;
	
	
	
	@GetMapping("/admin")
	public String adminhome(ModelMap map) {
		
		List<Admin> admin=adminrepo.findAll();
		List<Users>users=userimpl.getAllUsers();
		
				map.addAttribute("users",users);
				map.addAttribute("admin",admin);
		
		return "Adminsection/adminpage";
		
	}
	//..................................................

	@RequestMapping(value ="/product", method = RequestMethod.GET)
	public String addproduct(ModelMap map) {
	Product product= new Product();
		map.addAttribute("product",product);
	return "products/addproduct";	
	}
	
	@PostMapping(value ={"/product"})
	public String saveproduct(Product product,ModelMap map,@RequestParam("myImage") MultipartFile  myImage) {
	System.out.println("i called .......");
		
		productimpl.saveproduct(product,  myImage);
	
		
		return  "redirect:/admin"; 

}
	
	
	
	@RequestMapping(value ="/adddresses", method = RequestMethod.GET)
	public String adddresses(ModelMap map) {
	Product product= new Product();
		map.addAttribute("product",product);
		return "Adminsection/adddresses";	
	}
	
	@PostMapping(value ={"/adddresses"})
	public String adddresses1(Product product,ModelMap map,@RequestParam("myImage") MultipartFile  myImage) {
	
		
	product.setSize(1);
		productimpl.saveproduct(product,  myImage);
	
		
		return  "redirect:/admin";

}
	
	@RequestMapping(value ="/addshoes", method = RequestMethod.GET)
	public String addshoes(ModelMap map) {
	Product product= new Product();
		map.addAttribute("product",product);
		return "Adminsection/addshoes";	
	}
	
	@PostMapping(value ={"/addshoes"})
	public String addshoes1(Product product,ModelMap map,@RequestParam("myImage") MultipartFile  myImage) {
	
	product.setSize(2);
		productimpl.saveproduct(product,  myImage);
	
		
		return  "redirect:/admin"; 

}
	
	@RequestMapping(value ="/addwatches", method = RequestMethod.GET)
	public String addwatches(ModelMap map) {
	Product product= new Product();
		map.addAttribute("product",product);
		return "Adminsection/addwatches";	
	}
	
	@PostMapping(value ={"/addwatches"})
	public String addwatches1(Product product,ModelMap map,@RequestParam("myImage") MultipartFile  myImage) {
	
	product.setSize(3);
		productimpl.saveproduct(product,  myImage);
	
		
		return  "redirect:/admin"; 

}
	
	//...........................................................................
	
	
	@RequestMapping(value ="/confirm-{id}",method =RequestMethod.GET)
	public String confirmation(ModelMap map,@PathVariable("id")int id) {
		adminservice.shipping(id);
		String message ="Your order has confirmed and shipped to your address ";
		Optional<Admin> admin = adminrepo.findById((long) id);
		Users user =userrepo.findByUsername(admin.get().getUsername());
		Email email=new Email();
		email.sendEmail(user.getGmail(),message);
	    return "redirect:/admin";
}
	
	
	
	@RequestMapping(value ="/admindress", method = RequestMethod.GET)
	public String admindress(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBymaterial("dress");
	 
	map.addAttribute("allproduct",dress);
	return "Adminsection/adminshowproduct";
	
}
	
	@RequestMapping(value ="/adminfootwear", method = RequestMethod.GET)
	public String adminfootwear(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBymaterial("footwear");
	 
	map.addAttribute("allproduct",dress);
	return "Adminsection/adminshowproduct";
	
}
	
	@RequestMapping(value ="/adminwatches", method = RequestMethod.GET)
	public String adminwatches(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBymaterial("watch");
	 
	map.addAttribute("allproduct",dress);
	return "Adminsection/adminshowproduct";
	
}
	@RequestMapping(value ="/dressdelete-{id}",method =RequestMethod.GET)
public String dressdelete(ModelMap map,@PathVariable("id")int id) {
		
		Optional<Product> product =productrepo.findById((long) id);
		
		Optional<Product>product1=productrepo.findmaterial(product.get().getMaterial(),(long)id);
		Optional<Product>product2=productrepo.findmaterial("footwear",(long)id);
		
		
	
		
		if(product.get().getSize()==1) {
		productrepo.deleteById((long) id);
		System.out.println("product deleted");
		return "redirect:/admindress";}
		
		
		
		else if(product.get().getSize()==2) {
			productrepo.deleteById((long) id);
			System.out.println("Shoe deleted");
			return "redirect:/adminfootwear";}
		
		else if(product.get().getSize()==3) {
			productrepo.deleteById((long) id);
			System.out.println("watch deleted");
			return "redirect:/adminwatches";}
		
		else {
			System.out.println("not deleted");
		}
			return "redirect:/admin";
		}





}