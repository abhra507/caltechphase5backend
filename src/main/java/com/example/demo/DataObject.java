package com.example.demo;

import java.util.Arrays;

public class DataObject {
	private NewCart[] cart;
	private int restaurantid;
	public NewCart[] getCart() {
		return cart;
	}
	public void setCart(NewCart[] cart) {
		this.cart = cart;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	@Override
	public String toString() {
		return "DataObject [cart=" + Arrays.toString(cart) + ", restaurantid=" + restaurantid + "]";
	}
	public DataObject(NewCart[] cart, int restaurantid) {
		super();
		this.cart = cart;
		this.restaurantid = restaurantid;
	}
	public DataObject() {
		
		// TODO Auto-generated constructor stub
	}
  

	
	
	
	
	
	

}
