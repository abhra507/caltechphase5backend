package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	  @Autowired
	   RestaurantRepo rest;
	
	
    public List<Restaurant> getRestaurantlist(){
        List<Restaurant> r;
        r = rest.findAll();
        return r;
    }
    
    public Restaurant createRequest(Restaurant restaurant)
    {
    	return rest.save(restaurant);
    }

}
