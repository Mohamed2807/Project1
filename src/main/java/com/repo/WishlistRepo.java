package com.repo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist,Long>{
	
//	@Query(value ="SELECT a FROM Wishlist a WHERE a.wishid=?1 AND a.productid=?2 ")
//	Wishlist findbywishidandproductid(long wishid,long productid);
//	
	@Query(value ="SELECT a FROM Wishlist a WHERE a.productid=?1")
	Wishlist findbyproductid(long id);

}
