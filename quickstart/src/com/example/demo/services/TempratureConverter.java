package com.example.demo.services;

import com.example.demo.ifaces.Converter;

public class TempratureConverter implements Converter<Double> {

	@Override
	public Double apply(Double arg) {

		return  (5.0/9.0)* (arg-32);
	}

}
