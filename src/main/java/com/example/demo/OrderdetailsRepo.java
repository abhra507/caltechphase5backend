package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderdetailsRepo extends JpaRepository<Orderdetails,Integer>{
	
	

	String query="select order from Orderdetails order where order.username=?1";
	@Query(query)
	public List<Orderdetails> findbyusername(String username);

}
