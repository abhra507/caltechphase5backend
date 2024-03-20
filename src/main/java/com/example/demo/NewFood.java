package com.example.demo;

import javax.persistence.Entity;

import lombok.Data;


public class NewFood {
	   private String id;
	   private String restaurantname;
	   private int restaurantid;
	   private String name;
	   private int price;
	   private int quantityAvailable;
	   private String fileDataF;

	   public NewFood(){}

	@Override
	public String toString() {
		return "NewFood [id=" + id + ", restaurantname=" + restaurantname + ", restaurantid=" + restaurantid + ", name="
				+ name + ", price=" + price + ", quantityAvailable=" + quantityAvailable + ", fileDataF=" + fileDataF
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getFileDataF() {
		return fileDataF;
	}

	public void setFileDataF(String fileDataF) {
		this.fileDataF = fileDataF;
	}

	   
}
