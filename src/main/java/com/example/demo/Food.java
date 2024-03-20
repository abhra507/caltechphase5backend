package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Food {
	
	@Id
    private String id;
    private String restaurantname;
    private int restaurantid;
    private String item;
    private int price;
    private int quantity;
    private String url;
    private String formID;
    private String cartID;
    
    public Food()
    {
    	
    }
    
    public Food(String id,String restaurantname,int restaurantid, String item, int price,int quantity, String url, String formID, String cartID) {
        this.id = id;
        this.restaurantname=restaurantname;
        this.restaurantid=restaurantid;
        this.item = item;
        this.price = price;
        this.quantity=quantity;
        this.url=url;
        this.formID=formID;
        this.cartID=cartID;
    }

}
