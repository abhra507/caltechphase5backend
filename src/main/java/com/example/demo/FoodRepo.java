package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FoodRepo extends JpaRepository<Food,String> {
	
	
	String query="select food from Food food where food.restaurantid=?1  and food.restaurantname=?2";
	@Query(query)
	public List<Food> findbyrestaurantidrestaurantname(@Param("restaurantid") int restaurantid,@Param("restaurantname") String restaurantname);
    
	
	String query1="select food from Food food where food.restaurantid=?1";
	@Query(query1)
	public List<Food> findbyRestaurantid(int restaurantid);
}





