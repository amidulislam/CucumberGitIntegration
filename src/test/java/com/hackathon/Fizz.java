package com.hackathon;
public class Fizz {
	public static void main(String[] args) {
		Fizz obj=new Fizz();
		obj.printFizzBuzz(15);
	}

	void printFizzBuzz(int n){
			for(int i=1;i<=n;i++) {
				print(i);
			}
	}
	void print(int num) {
		if(num%3==0 && num%5==0) {			
			System.out.println("Fizz Buzz");			
		}
		else if(num%3==0) {
			System.out.println("Fizz");	
		}
		else if(num%5==0) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(num);
		}
	}
}

