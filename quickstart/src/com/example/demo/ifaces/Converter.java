package com.example.demo.ifaces;

@FunctionalInterface
public interface Converter<T> {

	T apply(T arg);
}
