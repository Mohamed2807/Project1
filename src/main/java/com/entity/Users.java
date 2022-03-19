package com.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private long id;
	@Column(name ="username")
	private String username;
	
	
	
	
	

	@Column(name ="gmail")
	private String gmail;
	@Column(name ="phonenumber")
	private long phonenumber;
	@Column(name ="password")
	private String password;
	@Column(name ="doorno")
	private String doorno;
	@Column(name ="street")
	private String street;
	@Column(name ="city")
	private String city;
	@Column(name ="pincode")
	private String pincode;
	@Column(name ="enable")
	@NonNull
	private long enable =1;
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public long getEnable() {
		return enable;
	}
	public void setEnable(long enable) {
		this.enable = enable;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	}
	
	
	

