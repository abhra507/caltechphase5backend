package com.example.demo;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
public class Orderdetails {
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	   @ElementCollection
	   @CollectionTable(name = "string_list", joinColumns = @JoinColumn(name = "entity_id"))
	   @Column(name = "string_value")
	private List<String> fooditem;
	private int quantity;
	private int total;
	private String username;
	private String datetime;
	private String shippingid;

}
