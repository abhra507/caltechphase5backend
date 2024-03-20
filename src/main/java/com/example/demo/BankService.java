package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class BankService {
	
	Logger log=Logger.getAnonymousLogger();
	@Autowired
	BankRepo rc;
    @Autowired
    CartRepo cartrepo;
    @Autowired
    FoodRepo foodrepo;
	
	public List<Bank> getbankdetails()
	{
		return rc.findAll();
	}
	
	public Bank updatebankdetails(int amount)
	{
		List<Bank> banks=rc.findAll();
		Bank bank=banks.get(0);
		System.out.println("the bank object received is "+bank.toString());
		System.out.println("the bank amount received is "+bank.getAmount());
		int finalamount=bank.getAmount()- amount;
	    bank.setAmount(finalamount);
	    rc.save(bank);	
		return bank;
	}
	
    public void updateDB(){
        List<Cart> carts =cartrepo.findAll();
        Cart cart = carts.get(1);
        List<Food> foods = foodrepo.findAll();
        foods.get(0).setQuantity(foods.get(0).getQuantity()-cart.getQuantity1());
        foods.get(1).setQuantity(foods.get(1).getQuantity()-cart.getQuantity2());
        foods.get(2).setQuantity(foods.get(2).getQuantity()-cart.getQuantity3());
        if(foods.size()>3)
        foods.get(3).setQuantity(foods.get(3).getQuantity()-cart.getQuantity4());
        if(foods.size()>4)
            foods.get(4).setQuantity(foods.get(4).getQuantity()-cart.getQuantity5());
        if(foods.size()>5)
            foods.get(5).setQuantity(foods.get(5).getQuantity()-cart.getQuantity6());
        foodrepo.saveAll(foods);
    }
    
	public Bank findbynamepsswd(String username,String password)
	{
		return rc.findbynameandpwd(username, password);
	}
    


	
	

}
