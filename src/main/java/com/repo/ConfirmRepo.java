package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Confirmation;



public interface ConfirmRepo extends JpaRepository<Confirmation, Long>{

}
