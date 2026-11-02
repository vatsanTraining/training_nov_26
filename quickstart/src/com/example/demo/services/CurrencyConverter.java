package com.example.demo.services;

import com.example.demo.ifaces.Converter;

public class CurrencyConverter implements Converter<Double> {

	@Override
	public Double apply(Double arg) {

		return arg * 100;
	}

}
