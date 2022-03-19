package com.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="wishes")
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private long id;
	
	
	@Column(name ="wishlist_id")
    private String wishlistid;
	
    @Column(name ="total")
	private long totalPrice;
    
    @Column(name ="totalcount")
    private long totalCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	


	public String getWishlistid() {
		return wishlistid;
	}

	public void setWishid(String wishlistid) {
		this.wishlistid = wishlistid;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public void setWishlistid(String wishlistid) {
		this.wishlistid = wishlistid;
	}

	
	
}
