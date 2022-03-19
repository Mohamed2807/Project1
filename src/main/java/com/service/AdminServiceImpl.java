package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.entity.Confirmation;
import com.entity.Users;
import com.entity.Wish;
import com.repo.Adminrepo;
import com.repo.ConfirmRepo;
import com.repo.WishRepo;
import com.repo.userRepo;

@Service
public class AdminServiceImpl implements Adminservice{
	
	@Autowired
	private WishlistServiceimpl wishrepo;
	
	@Autowired
	private WishRepo wrepo;
	
	@Autowired
	private Adminrepo adminrepo;
	
	@Autowired
	private userRepo repo;
	
	@Autowired
	private ConfirmRepo confirmrepo;

	@Override
	public void paidorder(String name) {
		 Optional<Confirmation> confirm=confirmrepo.findById((long) 1); 
		Users user=repo.findByGmail(confirm.get().getGmail());
		 Optional<Wish> wish =wrepo.findById((long) 1);
		 
		 Admin admin = new Admin();
		 admin.setUsername(user.getUsername());
		 admin.setPhonenumber(user.getPhonenumber());
		 admin.setAddress(user.getDoorno()+"<br>"+user.getStreet()+"<br>"+user.getCity()+user.getPincode());
		 admin.setCount(wish.get().getTotalCount());
		 admin.setTotal(wish.get().getTotalPrice());
		 admin.setPayment(name);
		 admin.setDelivery("pending");
		 adminrepo.save(admin);
		 
		
	}

	@Override
	public void shipping(int id) {
		// TODO Auto-generated method stub
        Admin admin1=new Admin();
		
		Optional<Admin> admin=adminrepo.findById((long) id);
		admin1.setId(admin.get().getId());
		 admin1.setUsername(admin.get().getUsername());
		 admin1.setPhonenumber(admin.get().getPhonenumber());
		 admin1.setAddress(admin.get().getAddress());
		 admin1.setCount(admin.get().getCount());
		 admin1.setTotal(admin.get().getTotal());
		 admin1.setPayment(admin.get().getPayment());
		 admin1.setDelivery("Confirmed");
		 adminrepo.saveAndFlush(admin1);
		 System.out.println("its updated");
		
	}

}
