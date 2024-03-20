package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Restaurant {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantid;
    private String restaurantname;
    private String item;
    private int price;
    private int quantity;


}
