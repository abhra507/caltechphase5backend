package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
@Id
private String name;
private String email;
private String password;
private String retypepassword;
private boolean merchant;
	
}
