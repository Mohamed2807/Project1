package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Admin;



public interface Adminrepo extends JpaRepository<Admin, Long> {

}
