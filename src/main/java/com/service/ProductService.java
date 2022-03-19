package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.entity.Product;



public interface ProductService {
	 List<Product> findAllProducts();
	 public void  saveproduct(Product product,MultipartFile file);
	    List<Product> findAllProductsForAdmin();

	    public Product findbyid(long id);

	    public void  deleteProduct(Integer id);

	    public void  updateProduct(Product product);

	    List<Product> findProductBymaterial(String material);
	    List<Product> findProductBybrand(String brand);

	Optional<Product> findProductByIdForAdmin(int id);
	

}
