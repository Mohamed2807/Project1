package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Wish_list")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
	private long id;
	
	@Column(name ="name")
     private String name;
	
//	@Column(name ="subtotal")
//	private long subtotal;
	
	@Column(name ="product_count")
	private long productcount;
	
	@Column(name ="buying_price")
	private long buyingprize;
	 
	@Column(name ="total")
	private long total;
	
	@Column(name ="product_id")
	private long productid;
	
	@Lob
	@Column(columnDefinition="LONGBLOB")
	private String myimageobj;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	
	

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getProductcount() {
		return productcount;
	}

	public void setProductcount(long productcount) {
		this.productcount = productcount;
	}



	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBuyingprize() {
		return buyingprize;
	}

	public void setBuyingprize(long buyingprize) {
		this.buyingprize = buyingprize;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getMyimageobj() {
		return myimageobj;
	}

	public void setMyimageobj(String myimageobj) {
		this.myimageobj = myimageobj;
	}

	
	

	



	

}
