package com.hackathon;

import java.util.LinkedHashMap;

import java.util.Map;

public class VarDemo {

	public static void main(String[] args) {
		var x="hello";
		var y=10;
		var map=new LinkedHashMap<String,String>();
		map.put("ele1", "100");
		map.put("ele2", "200");
		map.put("ele3", "300");
		map.put("ele4", "400");
		map.put("ele5", "500");
		for(var entry:map.entrySet()) {
			System.out.println("Key: "+entry.getKey());
			System.out.println("Value: "+entry.getValue());
		}

	}

}
