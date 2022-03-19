package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Wish;
import com.entity.Wishlist;

public interface WishRepo extends JpaRepository<Wish, Long> {
	
	
	@Query(value ="SELECT a FROM Wish a WHERE a.wishlistid=?1")
	Wishlist findbywishlistid(long id);

}
