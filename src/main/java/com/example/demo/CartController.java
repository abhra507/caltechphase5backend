package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

@Controller
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    CartService cartDao;

    
    @ResponseBody
    @RequestMapping("/cart")
    public int getTotal(@RequestBody NewCart[] cart, Model model){
        cartDao.saveToCart(cart);
        return cartDao.claculateTotal(cart);
    }
    @ResponseBody 
    @RequestMapping("/changeDB")
    public boolean changeDB(){
        cartDao.updateDB();
        return true;
    }
    @ResponseBody
    @RequestMapping("/addToCart")
    public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model) {       
      cartDao.addItems(cart);
       return cart;
   }
    

    @ResponseBody
    @RequestMapping("/addNewItem")
    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDao.addNewItem(file,newFoodData);
    }
   
    
    
    @ResponseBody
    @RequestMapping("/addNewItemUrl")
    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDao.addNewItemWithUrl(newFoodData);
    }
    @ResponseBody
    @RequestMapping("/checkItemId")
    public boolean checkItemId(@RequestBody String itemId, Model model){
        return !cartDao.itemIdAvailable(itemId);
    }
}
