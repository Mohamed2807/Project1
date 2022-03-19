package com.controller;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.config.Email;
import com.config.paymentconfig;
import com.entity.Confirmation;
import com.entity.Users;
import com.entity.Wish;
import com.paytm.pg.merchant.PaytmChecksum;
import com.repo.ConfirmRepo;
import com.repo.WishRepo;
import com.repo.userRepo;


@Controller
public class paymentController {
	
	
	@Autowired
	private paymentconfig paytmDetailPojo;
	@Autowired
	private Environment env;
	
	@Autowired
	private WishRepo wrepo;
	@Autowired
	private pdfcontroller pdfcontroller;
	
	
	
	@Autowired
	private userRepo repo;
	
	@Autowired
	private ConfirmRepo confirmrepo;
	
	
	@GetMapping("/payment")
	public String home() {
		return "payment/payment";
	}
	
	 
	
	 
	 
	 @PostMapping(value = "/submitPaymentDetail")
	    public ModelAndView getRedirect() throws Exception {

		 Optional<Confirmation> confirm=confirmrepo.findById((long) 1);
			Users user=repo.findByGmail(confirm.get().getGmail());
			String customerId="CUS"+(1000+user.getId());
			int a=1;
			String orderId ="ORD12"+a;
			
			a++;
			Optional<Wish> wish =wrepo.findById((long) 1);
			String	transactionAmount=Long.toString(wish.get().getTotalPrice());
			System.out.println(customerId);
			System.out.println(orderId);
			System.out.println(transactionAmount);
		 
		 
		 
	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	      
	        parameters.put("ORDER_ID", orderId);
	      
	        parameters.put("TXN_AMOUNT", transactionAmount);
	       
	        parameters.put("CUST_ID", customerId);
	       
	        String industryid="Retail";
	        String channelid="WEB";
	        parameters.put("INDUSTRY_TYPE_ID", industryid);
	      
        parameters.put("CHANNEL_ID", channelid);
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        System.out.println(channelid);
	        System.out.println(customerId);
			System.out.println(orderId);
			System.out.println(transactionAmount);
			System.out.println(industryid);
	       
	      
	        return modelAndView;
	    }
	 
	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        String paytmChecksum = "";
	        for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
	            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
	                paytmChecksum = requestParamsEntry.getValue()[0];
	            } else {
	            	parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
	            }
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        Email email= new Email();
	        Optional<Confirmation> confirm=confirmrepo.findById((long) 1);
	       
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                    pdfcontroller.generatepdf();
	                    email.sendAttach(confirm.get().getGmail());
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	      
	        
	        
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "payment/report";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,
	                paytmDetailPojo.getMerchantKey(), paytmChecksum);
	    }
	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetailPojo.getMerchantKey());
	}
}




//Users user=userrepo.findByGmail(confirm.get().getGmail());
// customerId="CUS"+(1000+user.getId());
//orderId =("ORD"+(1000+user.getId()));
//Optional<Wish> wish =wishrepo.findById((long) 1);
//transactionAmount=Long.toString(wish.get().getTotalPrice());