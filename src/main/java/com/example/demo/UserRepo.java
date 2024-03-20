package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String>{

	String query="select user from User user where user.name=?1 and user.password=?2";
	@Query(query)
	public User findbynameandpwd(String username,String password);
	

}
