package com.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Product;
import com.repo.ProductsRepo;



@Service

public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductsRepo prorepo;

	

	@Override
	public List<Product> findAllProducts() {
		 List<Product> products = new ArrayList<>();
		 prorepo.findAll().forEach(products::add);
		  return products;
	}

	@Override
	public List<Product> findAllProductsForAdmin() {
		
	        return null;
	}


	@Override
	public List<Product> findProductBybrand(String brand) {
		 List<Product> products = new ArrayList<>();
		 List<Product> productsCopy = new ArrayList<>();
		 prorepo.findBybrand(brand).forEach(products::add);
		    productsCopy.addAll(products);
		  return productsCopy;

	}

	@Override
	public Optional<Product> findProductByIdForAdmin(int id) {
		// TODO Auto-generated method stub
		
	        return prorepo.findById((long) id);
	}

	

	@Override
	public List<Product> findProductBymaterial(String material) {
		 List<Product> products = new ArrayList<>();
	        List<Product> productsCopy = new ArrayList<>();
	        prorepo.findBymaterial(material).forEach(products::add);
	        productsCopy.addAll(products);
	       
	        return productsCopy;
	    }

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void saveproduct(Product product,MultipartFile image) {
		// TODO Auto-generated method stub
		
		String imgfile=StringUtils.cleanPath(image.getOriginalFilename());
		
		
		if(imgfile.contains("..")) {
			System.out.println("not a valid file");
		}
		
		try {
			product.setMyimageobj(Base64.getEncoder().encodeToString(image.getBytes()));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		prorepo.save(product);
	}

	@Override
	public Product findbyid(long id) {
		// TODO Auto-generated method stub
		
		return prorepo.findById(id).orElse(new Product());
		
	}
	}

	


