package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
public class BankController {
	
	@Autowired
	BankService service;
	
	@ResponseBody
	@RequestMapping("/getbankdetails")
	public List<Bank> getBankdetails(HttpServletRequest request,HttpServletResponse response)
	 {		
		return service.getbankdetails();	
	}
	

	@ResponseBody
	@RequestMapping("/update/{total}")
	public Bank updatebankdetails(HttpServletRequest request,HttpServletResponse response,@PathVariable("total") String total)
	 {	
		int total1=Integer.parseInt(total);
		System.out.println("the total received is "+total);	
		Bank bb=service.updatebankdetails(total1);	
		if (bb !=null) {
		 return bb;
		}
		else
		{
			return null;
		}
	}	
	

	
 
	@ResponseBody
	@RequestMapping("/dobanklogin")
	public Bank loginProcess(@RequestBody Bank bank, Model model) {
	   Bank  bb = service.findbynamepsswd(bank.getUsername(),bank.getPassword());	   
	   if(bb!=null) {
	    System.out.println("Welcome");
				}
		else {
			System.out.println("login failed");
		}   
	   
	    return bb;
	}
	




}
