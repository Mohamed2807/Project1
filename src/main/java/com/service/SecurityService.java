package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.Confirmation;
import com.entity.Users;
import com.entity.Wish;
import com.repo.ConfirmRepo;
import com.repo.UserPricipal;
import com.repo.WishRepo;
import com.repo.userRepo;

@Service
public class SecurityService implements UserDetailsService
{

	@Autowired
	private userRepo repo;
	
	 Confirmation confirm=new Confirmation();
	
	@Autowired
	private WishRepo wrepo;
	@Autowired
    private WishlistServiceimpl wishrepo;
	
	@Autowired
    private ConfirmRepo confirmrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Confirmation confirm=new Confirmation();
		Users  user=repo.findByGmail(username);
		System.out.println(user.getGmail());
	    confirm.setId(1);
		confirm.setGmail(user.getGmail());
		
		confirmrepo.save(confirm);
	
		wishrepo.DeleteWish();
		
		Wish wish = new Wish();
		wish.setId(1);
	    wish.setTotalPrice(0);
	    wish.setTotalCount(0);
		wrepo.save(wish);
	
		
		return new UserPricipal(user);
	}

}
