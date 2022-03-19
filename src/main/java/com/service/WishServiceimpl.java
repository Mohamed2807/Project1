package com.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.entity.Wish;
import com.entity.Wishlist;
import com.repo.ProductsRepo;
import com.repo.WishRepo;
import com.repo.WishlistRepo;

@Service
public class WishServiceimpl implements WishService {

	@Autowired
	private WishRepo wishrepo;
	@Autowired
	private WishlistRepo wishlistrepo;
	
	@Autowired
	private ProductsRepo prorepo;
	
//	@Autowired
//	private WishlistServiceimpl wishlistimpl;
	Wish wish=new Wish();
	@SuppressWarnings("unused")
	@Override
	public void addtotal(Wishlist wishlist,Product product) {
		Optional<Wishlist> wishlist1= wishlistrepo.findById(wishlist.getId());
		Optional<Product> product1 =prorepo.findById(product.getId());
		
		if(wish==null) {
			wish.setTotalPrice(wishlist1.get().getTotal() );
			wish.setTotalCount(wishlist1.get().getProductcount());
		wishrepo.save(wish);}

		
		else {
			
		
		
		wish.setId(1);
		
			wish.setTotalPrice(wish.getTotalPrice()+product1.get().getPrize() );
			wish.setTotalCount(wish.getTotalCount()+1);
			wishrepo.save(wish);
			System.out.println(wish.getTotalPrice());
			System.out.println(wish.getTotalCount());
		}
		System.out.println(wish.getTotalPrice());
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public Wish showtotal() {
		// TODO Auto-generated method stu
		
		return (Wish) wishrepo.findAll();
		
	}
	@Override
	public Wish findbyid(long id) {
		// TODO Auto-generated method stub
		
		return wishrepo.findById(id).orElse(new Wish());
	}

//	@Override
//	public void addtowish(String session, long productid) {
//		// TODO Auto-generated method stub
//		
//		Wish wish =wishrepo.findBySession(session);
//		if(wish == null) {
//			wish =new Wish();
//			wish.setSession(session);
//			wishrepo.save(wish);
//		}
//		
//		wishlistimpl.addwishlist(wish.getId(), productid);
//		Set<Wishlist> wishitems =wishlistimpl.findbywishid(wish.getId());
//		wish.setWishlist(wishitems);
//		wish.setTotalPrice(wishlistimpl.getTotalPrice(wish));
//		wishrepo.save(wish);
//		
//	}

//	@Override
//	public Wish findbySession(String session) {
//		// TODO Auto-generated method stub
//		return wishrepo.findBySession(session);
//	}
//
//	@Override
//	public void addtowish(String session, long productid) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
