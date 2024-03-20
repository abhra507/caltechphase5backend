package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@CrossOrigin(origins = "*")
public class RestaurantController {
	
	Logger log=Logger.getAnonymousLogger();
	@Autowired
	RestaurantService service1;
	
	@ResponseBody
	@RequestMapping("/getallrestaurants")
	public List<Restaurant> getallrestaurants(Model model,HttpServletRequest request,HttpServletResponse response) {
		 List<Restaurant> restaurants ;
		 restaurants = service1.getRestaurantlist();
	        return restaurants;
	}
	
	@ResponseBody
	@RequestMapping("/Restaurantonboarding")
	public Restaurant createRequest(Model model,HttpServletRequest request,HttpServletResponse response,@RequestBody Restaurant restaurant) {
		 System.out.println(restaurant.toString());
		    service1.createRequest(restaurant);
		    return restaurant;
	}
	
	

}




