package com.service;

import java.util.Optional;

import com.entity.Product;
import com.entity.Wish;
import com.entity.Wishlist;

public interface WishService {
	
	
	
	
	public Wish showtotal();

	public void addtotal(Wishlist wishlist,Product product);
	
	Wish findbyid(long id);

}
