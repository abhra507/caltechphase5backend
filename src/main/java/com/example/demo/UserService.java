package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	
	@Autowired
	UserRepo repo;

	public User createuser(User user)
	{
		return repo.save(user);
	}
	
	public User findbynamepsswd(String username,String password)
	{
		return repo.findbynameandpwd(username, password);
	}

	
	public Boolean findbynamepssword(String username,String password)
	{
		User e=repo.findbynameandpwd(username, password);
		if (e !=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	  public void register(User user) {
		  repo.save(user);
	    }

	    public User validateUser(Login login) {
	        User user = null;
	        if (repo.findById(login.getUsername()).isPresent()) {
	            user = repo.findById(login.getUsername()).get();
	            if(!user.getPassword().equals(login.getPassword()))
	                user=null;
	        }
	        return user;
	    }
	    
	    
		public User findbynamepsswd(User user)
		{
			
			String username =user.getName();
			String password= user.getPassword();
			return repo.findbynameandpwd(username, password);
		}

	    

	    public Boolean usernameExists(String username){
	       return repo.findById(username).isPresent();
	    }
	    
	    
		public Boolean findbynamepssword1(String username,String password)
		{
			User e=repo.findbynameandpwd(username, password);
			if (e !=null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

	


}
