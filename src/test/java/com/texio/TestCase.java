package com.texio;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.pizz.PizzaOrderInformation;

public class TestCase {
	PizzaOrderInformation pizzaOrderInformation;
	@Test
	void bookPizza() {
		getTestData();
		var data=getTestData();
		for(Map<String,String> pizzaInfo:data) {
			pizzaOrderInformation=new PizzaOrderInformation();
			pizzaOrderInformation.orderPizza(pizzaInfo);			
		}
		
			}
	List<Map<String,String>> getTestData(){
		List<Map<String,String>> data=null;
		//Logic for reading all the test data from the excel using XSSFWorkBook class
		return data;
	}

}
