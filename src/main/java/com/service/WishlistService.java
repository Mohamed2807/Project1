package com.service;

import java.util.List;
import java.util.Set;

import com.entity.Product;
import com.entity.Wish;
import com.entity.Wishlist;



public interface WishlistService {

	
//	public void addwishlist(long wishid,long productid);
//	
//	Long getTotalPrice(Wish wish);
//	
	public List<Wishlist>findWishlist();
//	
//	
//	
//	void removeFromWish (Wish wish,Product product);
//	
//	void clearwish (Wish wish);
//	
void DeleteWish();
//
//	Set<Wishlist> findbywishid(long id);
	
	public void addwishlist(long id);

	
}
