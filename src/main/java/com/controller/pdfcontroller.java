package com.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.config.Email;
import com.entity.Confirmation;
import com.entity.Users;
import com.repo.ConfirmRepo;
import com.repo.userRepo;
import com.service.AdminServiceImpl;

import com.service.WishlistServiceimpl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class pdfcontroller {
		@Autowired
		WishlistServiceimpl wishimpl;
		@Autowired
		private userRepo repo;
		
		@Autowired
		private ConfirmRepo confirmrepo;
		
		@Autowired
		private AdminServiceImpl adminservice;

		//
		//public String generatepdf()
		@GetMapping("/pdf")
		public ResponseEntity<byte[]> generatepdf1()throws FileNotFoundException, JRException {
			adminservice.paidorder("Cash And Delivery");
			
			Optional<Confirmation> confirm = confirmrepo.findById((long) 1);
			
			Users user = repo.findByGmail(confirm.get().getGmail());
			JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(wishimpl.findWishlist());
			
			JasperReport jasper =JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Invoice_1.jrxml"));
			
			HashMap<String,Object > map = new HashMap<>();
			map.put("name", user.getUsername());
			map.put("doorno", user.getDoorno());
			map.put("area", user.getStreet());
			map.put("city", user.getCity());
			map.put("pincode", user.getPincode());
			map.put("phone", user.getPhonenumber());
			
			
			
		JasperPrint report=	JasperFillManager.fillReport(jasper,map,beanCollectionDataSource);
		
	     JasperExportManager.exportReportToPdfFile(report, "bill.pdf");

		
		byte[] data = JasperExportManager .exportReportToPdf(report);
		
		HttpHeaders headers= new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=invoice.pdf");
		  Email email = new Email();
		     String message="you have ordered items with Cash and delivery,we will recieve you a confirmation of shipping after verifying your your details";
		     email.sendEmail(confirm.get().getGmail(), message);
			
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		
		
		}
		
		public ResponseEntity<byte[]> generatepdf()throws FileNotFoundException, JRException {
	adminservice.paidorder("Online payment");
			
			Optional<Confirmation> confirm = confirmrepo.findById((long) 1);
			
			Users user = repo.findByGmail(confirm.get().getGmail());
			JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(wishimpl.findWishlist());
			
			JasperReport jasper =JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Invoice_1.jrxml"));
			
			HashMap<String,Object > map = new HashMap<>();
			map.put("name", user.getUsername());
			map.put("doorno", user.getDoorno());
			map.put("area", user.getStreet());
			map.put("city", user.getCity());
			map.put("pincode", user.getPincode());
			map.put("phone", user.getPhonenumber());
			
			
			
		JasperPrint report=	JasperFillManager.fillReport(jasper,map,beanCollectionDataSource);
		
	     JasperExportManager.exportReportToPdfFile(report, "bill.pdf");
	   
		return null;
		}
		
	}

