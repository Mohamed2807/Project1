package com.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Users;


public interface userRepo extends JpaRepository<Users, Long> {
	@Query(value = "SELECT a FROM Users a WHERE a.gmail=?1 AND a.password = ?2")
	 Optional<Users> findByEmailAndPassword(String gmail , String password);
	
	public Users getUserByid(int userid);
	public void deleteByid(int userid);
	@Query(value = "SELECT a FROM Users a WHERE a.gmail=?1 ")
	public Users findByGmail(String gmail);
	@Query(value = "SELECT a FROM Users a WHERE a.username=?1 ")
	public Users findByUsername(String username);

}
