package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankRepo extends JpaRepository<Bank,String>{	
	String query="select bank from Bank bank where bank.username=?1 and bank.password=?2";
	@Query(query)
	public Bank findbynameandpwd(String username,String password);
	

}
