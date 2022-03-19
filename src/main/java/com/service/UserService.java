package com.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.entity.Users;


public interface UserService {
	Optional<Users> login(String username,String password);
	public Users register(Users user);
	public List<Users> getAllUsers(); 
	public Users add(Users user);
	public void deleteuserbyid(long userid);
	public Users getuserbyid(long userid);
	public Users extractUserModel(HttpServletRequest request);
}
