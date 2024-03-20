package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepo extends JpaRepository<Cart,Integer>{	

   	String query="delete from Cart cart where cart.quantity1=:did";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(query)
	public int deletebyQuantity(@Param("did") int did);
	
}

