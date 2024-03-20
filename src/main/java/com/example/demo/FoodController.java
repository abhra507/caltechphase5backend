package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    FoodService foodDao;
    
    @ResponseBody
    @RequestMapping("/menu/{restaurantid}/{restaurantname}")
    public List<Food> getMenu(Model model,HttpServletRequest request,HttpServletResponse response,@PathVariable("restaurantid") int restaurantid,@PathVariable("restaurantname") String restaurantname) {
        List<Food> foodItems ;
        foodItems = foodDao.getFoodListbyrestaurantid(restaurantid,restaurantname);
        return foodItems;
    }


}
