package com.pizz;

import java.util.Map;

import com.utility.ReusableUtility;

public class PizzaOrderInformation {
	String pizzaName="PizzaName";	
	String pizzaQuantity="Quantity";
	String pizzaTopping="Toppings";	
	String pizzaSize="Size";	
	public void orderPizza(Map<String,String> pizzaInfo) {
		ReusableUtility.getInstance().getWebElementById(pizzaInfo.get("PizzaName")).click();
		ReusableUtility.getInstance().getWebElementById(pizzaInfo.get("Quantity")).click();
		ReusableUtility.getInstance().getWebElementById(pizzaInfo.get("Toppings")).click();
		ReusableUtility.getInstance().getWebElementById(pizzaInfo.get("Size")).click();
	}
}
