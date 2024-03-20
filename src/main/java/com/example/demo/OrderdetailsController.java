package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
public class OrderdetailsController {
	
    @Autowired
    OrderdetailsService se;
    @Autowired
	 FoodRepo foodDao1;
    @Autowired
    CartRepo cartDao1;
    
    @ResponseBody
    @RequestMapping("/getallOrders/{name}")
    public List<Orderdetails> getallOrders(Model model,HttpServletRequest request,HttpServletResponse response,@PathVariable("name") String name) {
        List<Orderdetails> orders ;
        orders = se.getOrders(name);
        return orders;
    }
    
    @ResponseBody
    @RequestMapping("/updateOrderdetails/{total}/{username}")
    public Orderdetails updateOrderdetails(HttpServletRequest request,HttpServletResponse response,@PathVariable("total") String total,@PathVariable("username") String username) {
    	int total1=Integer.parseInt(total);  	
    	List<Cart> carts =cartDao1.findAll();
        Cart cart = carts.get(0);
        System.out.println("the cart received is "+cart.toString());
    	List<Food> food=foodDao1.findAll();
    	Orderdetails o=new Orderdetails();  
    	List<String> str=new ArrayList<String>();
    	if(cart.getQuantity1() >0)
    	{
    		str.add(food.get(0).getItem());
    	}
    	if(cart.getQuantity2() >0)
    	{
    		str.add(food.get(1).getItem());
    	}
     	if(cart.getQuantity3() >0)
    	{
    		str.add(food.get(2).getItem());
    	}
     	if(cart.getQuantity4() >0)
    	{
    		str.add(food.get(3).getItem());
    	}
     	if(cart.getQuantity5() >0)
    	{
    		str.add(food.get(4).getItem());
    	}
     	if(cart.getQuantity6() >0)
    	{
    		str.add(food.get(5).getItem());
    	}
     	o.setFooditem(str);
     	LocalDateTime currentDateTime = LocalDateTime.now();
     	String time=currentDateTime.toString();
     	o.setDatetime(time);
     	o.setUsername(username);
    	o.setQuantity(cart.getQuantity1()+cart.getQuantity2()+cart.getQuantity3()+cart.getQuantity4()+cart.getQuantity5()+cart.getQuantity6());
    	o.setTotal(total1);
    	o.setShippingid(UUID.randomUUID().toString());
        se.updateOrderdetails(o);
        return o;
    }
    

 
    

}


