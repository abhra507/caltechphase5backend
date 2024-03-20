package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderdetailsService {
	
	  @Autowired
	  OrderdetailsRepo ren;
	   @Autowired
	   FoodRepo foodDao1;
	   @Autowired
	   CartRepo cartDao1;
	   
	
   public List<Orderdetails> getOrders(String name){
       List<Orderdetails> o;
     //  o = ren.findAll();
       o=ren.findbyusername(name);
       return o;
   }
   
   public void updateOrderdetails(Orderdetails o){
       ren.save(o);
       }
   
   
   
   
 

}
