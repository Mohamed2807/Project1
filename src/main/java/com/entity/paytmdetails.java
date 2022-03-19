package com.entity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.repo.ConfirmRepo;
import com.repo.WishRepo;
import com.repo.userRepo;

public class paytmdetails {

	@Autowired
	private WishRepo wrepo;	
	
	@Autowired
	private userRepo repo;
	@Autowired
	private ConfirmRepo confirmrepo;
	

	
	
	
	 Optional<Confirmation> confirm=confirmrepo.findById((long) 1); 
	 
		Users user=repo.findByGmail(confirm.get().getGmail());
	 Optional<Wish> wish =wrepo.findById((long) 1);
	
	
			
	String orderid="ord"+(1000+user.getId());
	String totalamount=Long.toString(wish.get().getId());
	String customid="cus"+(1000+user.getId());
	String industryid="Retail";
	String channelid="WEB";
	public paytmdetails(String orderid, String totalamount, String customid, String industryid, String channelid) {
		super();
		this.orderid = orderid;
		this.totalamount = totalamount;
		this.customid = customid;
		this.industryid = industryid;
		this.channelid = channelid;
	}
	
//	public String getOrderid() {
//		return orderid;
//	}
//	public void setOrderid(String orderid) {
//		this.orderid = orderid;
//	}
//	public String getTotalamount() {
//		return totalamount;
//	}
//	public void setTotalamount(String totalamount) {
//		this.totalamount = totalamount;
//	}
//	public String getCustomid() {
//		return customid;
//	}
//	public void setCustomid(String customid) {
//		this.customid = customid;
//	}
//	public String getIndustryid() {
//		return industryid;
//	}
//	public void setIndustryid(String industryid) {
//		this.industryid = industryid;
//	}
//	public String getChannelid() {
//		return channelid;
//	}
//	public void setChannelid(String channelid) {
//		this.channelid = channelid;
//	}

}
