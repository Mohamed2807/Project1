package com.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Wish;
import com.entity.Wishlist;
import com.repo.ProductsRepo;
import com.repo.WishRepo;
import com.repo.WishlistRepo;





@Service
public class WishlistServiceimpl implements WishlistService{


	
	@Autowired
	private ProductsRepo prorepo;
	
	@Autowired
	private WishlistRepo wishrepo;
	
	
	
    public WishlistServiceimpl(WishlistRepo wishrepo) {
	this.wishrepo=wishrepo;
	// TODO Auto-generated constructor stub
}

    Wishlist wishlist =new Wishlist();

	
	
	@Override
	public void addwishlist(long id) {
		// TODO Auto-generated method stub
		
	Optional<Product> product=	prorepo.findById(id);
	
	Wishlist wish=wishrepo.findbyproductid(id);
	
	
		if(wish != null) {
		
			
			wish.setProductcount(wish.getProductcount()+1);
		
			wish.setTotal(product.get().getPrize()*wish.getProductcount());
			wishrepo.save(wish);
			System.out.println("updated");
			
			System.out.println(wish.getId());
			System.out.println(product.get().getId());
			
			//  wishlist = new Wishlist();
		}
		else {
			
			
			wishlist.setProductid(product.get().getId());
			wishlist.setName(product.get().getName());
			wishlist.setProductcount(1);
			wishlist.setBuyingprize(product.get().getPrize());
			wishlist.setTotal(product.get().getPrize());
			wishlist.setMyimageobj(product.get().getMyimageobj());
			wishrepo.save(wishlist);
			
			System.out.println("before");
		
			System.out.println(product.get().getId());
			
			wishlist = new Wishlist();
			
			
			System.out.println("saved");
		}
		
		
		
		
	}



	@Override
	public List<Wishlist> findWishlist() {
		// TODO Auto-generated method stub
		return wishrepo.findAll();
	}



	@Override
	public void DeleteWish() {
		// TODO Auto-generated method stub
		 wishrepo.deleteAll();
	}


	
	

	
	

}
