package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Product;
import com.service.ProductServiceimpl;


@Controller
public class productcontroller {
//	

	@Autowired
	private ProductServiceimpl productimpl;
	

	
	
//	................................................................
	@GetMapping(value= {"/productdress"})
	public String showdress(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBymaterial("dress");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
	
	@GetMapping(value= {"/productwatches"})
	public String showmaterial(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBymaterial("watch");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
	
	
	@GetMapping(value= {"/productfootwear"})
	public String showfootwear(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBymaterial("footwear");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
		
	//....................................................................................
	
	
	
	@GetMapping(value= {"/formalshirt"})
	public String formalshirt(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBybrand("formalshirt");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
	@GetMapping(value= {"/plainshirt"})
	public String plainshirt(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBybrand("plainshirt");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
	@GetMapping(value= {"/checkedShirts"})
	public String checkedShirts(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBybrand("checkedShirts");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}
	@GetMapping(value= {"/printedshirts"})
	public String printedshirts(ModelMap map) {
		
		List<Product> dress=productimpl.findProductBybrand("printedshirts");
	 
		map.addAttribute("allproduct",dress);
		
		return "products/showproduct";
	}

	

//..........................................................................

@GetMapping(value= {"/formalpants"})
public String formalpants(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("formalpants");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}

@GetMapping(value= {"/shorts"})
public String shorts(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("shorts");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}
@GetMapping(value= {"/jeanpants"})
public String jeanpants(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("jeanpants");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}

@GetMapping(value= {"/checkedpants"})
public String checkedpants(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("checkedpants");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}
//....................................................
//....................................................

@GetMapping(value= {"/formalshoes"})
public String formalshoes(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("formalshoes");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
	
}
@GetMapping(value= {"/sportshoes"})
public String sportshoes(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("sportshoes");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}
@GetMapping(value= {"/chapal"})
public String chapal(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("chapal");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";
}
//....................................................................
@GetMapping(value= {"/analogwatch"})
public String analogwatch(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("analogwatch");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";}

@GetMapping(value= {"/digitalwatch"})
public String digitalwatch(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("digitalwatch");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";}

@GetMapping(value= {"/smartwatch"})
public String smartwatch(ModelMap map) {
	
	List<Product> dress=productimpl.findProductBybrand("smartwatchwatch");
 
	map.addAttribute("allproduct",dress);
	
	return "products/showproduct";}


}

