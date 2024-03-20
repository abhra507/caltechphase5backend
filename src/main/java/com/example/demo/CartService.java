package com.example.demo;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



@Service
public class CartService {
	
	  @Autowired
	    CartRepo cartDao;

	    @Autowired
	    FoodRepo foodDao;

	    @Value("${fileStorage}")
	    private String storagePath;

	    public void saveToCart(NewCart[] newCarts){
	    	List<Cart> carts2 =cartDao.findAll();
	       	if(!carts2.isEmpty()) {
	    		deleteCart();
	    	}	      
	        Cart cart= new Cart(1,0,0,0,0,0);
	        cart.setQuantity1(newCarts[0].getQuantity());
	        cart.setQuantity2(newCarts[1].getQuantity());
	        cart.setQuantity3(newCarts[2].getQuantity());
	        if(newCarts.length>3)
	            cart.setQuantity4(newCarts[3].getQuantity());
	        if(newCarts.length>4)
	        cart.setQuantity5(newCarts[4].getQuantity());
	        if(newCarts.length>5)
	        cart.setQuantity6(newCarts[5].getQuantity());	        
	        cartDao.save(cart);
	       	
	    }
	    
	   
	    public String deleteCart()
	    {
	        List<Cart> carts =cartDao.findAll();
	        if(!carts.isEmpty()) {
	        Cart cart1 = carts.get(0);
	        System.out.println("the value of cart1 "+cart1.toString());
	        System.out.println("the value of cart1 quantity "+cart1.getQuantity1());
	        cartDao.deletebyQuantity(cart1.getQuantity1());
	        cartDao.flush();
	        return "updated id of "+cart1.getQuantity1();
	        }

	        return "updated id" ;
	    	
	    }

	    public void updateDB(){
	        List<Cart> carts =cartDao.findAll();
	        Cart cart = carts.get(0);
	        List<Food> foods = foodDao.findAll();
	        foods.get(0).setQuantity(foods.get(0).getQuantity()-cart.getQuantity1());
	        foods.get(1).setQuantity(foods.get(1).getQuantity()-cart.getQuantity2());
	        foods.get(2).setQuantity(foods.get(2).getQuantity()-cart.getQuantity3());
	        if(foods.size()>3)
	        foods.get(3).setQuantity(foods.get(3).getQuantity()-cart.getQuantity4());
	        if(foods.size()>4)
	            foods.get(4).setQuantity(foods.get(4).getQuantity()-cart.getQuantity5());
	        if(foods.size()>5)
	            foods.get(5).setQuantity(foods.get(5).getQuantity()-cart.getQuantity6());
	        foodDao.saveAll(foods);
	    }

	    public List<Cart> getAllCart(){
	        return cartDao.findAll();
	    }

	    public void addItems(NewCart[] cart){
	        List<Food> foods = foodDao.findAll();
	        for(int i=0;i<foods.size();i++){
	        	
	            foods.get(i).setQuantity(foods.get(i).getQuantity()+cart[i].getQuantity());
	        }
	        foodDao.saveAll(foods);
	        
	    }

	    public boolean addNewItem(MultipartFile file, String newFoodData) throws IOException {
	        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
	        if(!file.isEmpty())
	        if(saveFileToAssets(file))
	        {
	        	
	         foodDao.save(new Food(newFood.getId(),newFood.getRestaurantname(),newFood.getRestaurantid(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"C:\\\\Users\\\\Abhra\\\\Documents\\\\assets\\\\images\\\\"+file.getOriginalFilename(),"",""));

	        }
	        return true;
	    }

	    public boolean addNewItemWithUrl(String newFoodData) throws IOException {
	        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
	        foodDao.save(new Food(newFood.getId(),newFood.getRestaurantname(),newFood.getRestaurantid(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),newFood.getFileDataF(),"",""));
	        return true;
	    }

	    private boolean saveFileToAssets(MultipartFile file) throws IOException {
	        Path filepath = Paths.get(storagePath, file.getOriginalFilename());
	        System.out.println("the path of the file is "+filepath.toString());
	        file.transferTo(filepath);
	        return true;
	    }

	    public int claculateTotal(NewCart[] newCart){
	        int total=0;
	        List<Food> foods = foodDao.findAll();

	        for(int i=0;i<foods.size();i++)
	        {
	            total+=foods.get(i).getPrice()*newCart[i].getQuantity();
	        }
	        return total;
	    }

	    public boolean itemIdAvailable(String itemId) {
	        return foodDao.findById(itemId).isPresent();
	    }

}
