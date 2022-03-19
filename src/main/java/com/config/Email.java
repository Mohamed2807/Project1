package com.config;

import java.io.File;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Wish;
import com.repo.WishRepo;

public class Email {
//	@Autowired
//   private 	WishRepo repo;
//	public Email() {
//		// TODO Auto-generated constructor stub
//		
////		String message ="hello,dear,this is message for security check.";
////		String subject ="CodeArea :Confirmation";
////		String to ="muhammadashik1344@gmail.com";
////		String from = "kabshashopping@gmail.com";
//		
//		//sendEmail(message,subject,to,from);
//			//	sendAttach(message,subject,to,from);
//	}	

 public static void sendAttach(String to) {
	// TODO Auto-generated method stub
String host="smtp.gmail.com";

String message ="Your Payment has been sucessfully Received.Thanks for Helping US"
		+ "we will recive you a confirmation of shipping, after verifying your details"
		+"we listed below your ordered item in pdf Form";
		
		 
		
String subject="E-Commerce Kabsha Shopping";
String from="kabshashopping@gmail.com";
	
	//get the system properties 
	Properties properties = System.getProperties();
	System.out.println("PROPERTIES"+properties);
	
	//setting impoetant information to properties object
	
	
	//host set
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.auth", "true");
			
	//step 1:to get session object...
		Session session=	Session.getInstance(properties,new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication("kabshashopping@gmail.com", "kabsha2807");
				}
				
				
				
			});
			session.setDebug(true);
//step 2:compose the message [text,multimedia]
		MimeMessage  m = new MimeMessage(session);
		
		//from email
		try {
			m.setFrom(from);
			
			// adding recipients 
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			
			m.setSubject(subject);
			
			//attachment
			String path="G:\\Kabsha\\bill.pdf";
			
			
			 MimeMultipart multipart =	new MimeMultipart();
			 
			 m.setContent(multipart);
			 
			 MimeBodyPart textmime= new MimeBodyPart();
			 
			 MimeBodyPart filemime= new MimeBodyPart();
			 
			 try {
				 textmime.setText(message);
				 
				 File file=new File(path);
				 
				 filemime.attachFile(file);
				 
				 multipart.addBodyPart(textmime);
				 multipart.addBodyPart(filemime);
				 
				 
				
			} catch ( Exception e) {
				// TODO: handle exception
			}
			 
			
			//send
			
			//step 3:send the message using Transport class
			Transport.send(m);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

 public static  void sendEmail(String to,String message) {
	
	String subject="E-Commerce Kabsha Shopping";
	String from="kabshashopping@gmail.com";
    String host="smtp.gmail.com";
	
	Properties properties = System.getProperties();
	System.out.println("PROPERTIES"+properties);
	
	properties.put("mail.smtp.host", host);
	properties.put("mail.smtp.port", "465");
	properties.put("mail.smtp.ssl.enable", "true");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.auth", "true");
	
	Session session=	Session.getInstance(properties,new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("kabshashopping@gmail.com", "kabsha2807");
		}});	
        session.setDebug(true);

         MimeMessage  m = new MimeMessage(session);
	
	try {
		m.setFrom(from);
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		m.setSubject(subject);
		

		 MimeMultipart multipart =	new MimeMultipart();
		 
		 m.setContent(multipart);
		
		 MimeBodyPart textmime= new MimeBodyPart();
		 
		 try {
			textmime.setText(message);
			
			multipart.addBodyPart(textmime);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Transport.send(m);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
public   void payment(String to) {
	
	//Optional<Wish> wish = repo.findById((long) 1);
	
	
	String message ="Your Payment has been sucessfully Received.<br>you have paid the amount of <br>Thanks for Helping US";
			
			 
			
	String subject="E-Commerce Kabsha Shopping";
	String from="kabshashopping@gmail.com";
   String host="smtp.gmail.com";
	
	Properties properties = System.getProperties();
	System.out.println("PROPERTIES"+properties);
	
	properties.put("mail.smtp.host", host);
	properties.put("mail.smtp.port", "465");
	properties.put("mail.smtp.ssl.enable", "true");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.auth", "true");
	
	Session session=	Session.getInstance(properties,new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("kabshashopping@gmail.com", "kabsha2807");
		}});	
       session.setDebug(true);

        MimeMessage  m = new MimeMessage(session);
	
	try {
		m.setFrom(from);
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		m.setSubject(subject);
		

		 MimeMultipart multipart =	new MimeMultipart();
		 
		 m.setContent(multipart);
		
		 MimeBodyPart textmime= new MimeBodyPart();
		 
		 try {
			textmime.setText(message);
			
			multipart.addBodyPart(textmime);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Transport.send(m);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}



}