package com.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.Users;
import com.repo.userRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	userRepo userRep;
	
	
		
	public UserServiceImpl(userRepo userRep) {
		// TODO Auto-generated constructor stub
		this.userRep=userRep;
	}
	//...........................................................
	@Override
	public Optional<Users> login(String email,String password) {
		return userRep.findByEmailAndPassword(email, password);
	}
	//...............................................

	@Override
	public Users register(Users user) {
		// TODO Auto-generated method stub
		
		userRep.save(user);
		return null;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> users=userRep.findAll();
		
		return users;
	}

	@Override
	public Users add(Users user) {
		// TODO Auto-generated method stub
		userRep.save(user);
		return null;
	}
	@Override
	public void deleteuserbyid(long userid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Users getuserbyid(long userid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Users extractUserModel(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	

	
	

}
