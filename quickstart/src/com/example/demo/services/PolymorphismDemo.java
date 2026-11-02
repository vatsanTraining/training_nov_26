package com.example.demo.services;

import com.example.demo.ifaces.Converter;

public class PolymorphismDemo {

	
	public static void print(Converter<Double> obj,Double arg) {
		
		System.out.println(obj.apply(arg));
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Converter<Double> currency = new CurrencyConverter();
		
		print(currency,100.00);
		
		
		Converter<Double> temp = new TempratureConverter();
		
		print(temp,34.00);
		
		
		
	}

}
