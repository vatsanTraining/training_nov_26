package com.example.demo;

import java.util.Arrays;
import java.util.List;

import com.example.demo.ifaces.Converter;

//public class CurrencyConverter implements Converter<Double> {
//
//	@Override
//	public Double apply(Double arg) {
//
//		return arg * 100;
//	}
//
//}

public class UsingLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Converter<Double> lambOne =  arg-> arg * 100;
		
		System.out.println(lambOne.apply(40.00));
		
		String[] names = {"Ram","Shyam","Sunil"};
		
		List<String> nameList = Arrays.asList(names);
		
		nameList.forEach(e -> System.out.println(e));
		
		nameList.forEach(System.out::println);
		
	
	}

}
