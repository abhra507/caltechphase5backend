package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Bank {

	@Id
	private String username;
	private String password;
	private int amount;
}

