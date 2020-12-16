package com.spring.basic.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		
//		Chef chef = new Chef();
//		Restaurant res = new Restaurant(chef);
//		Hotel hotel = new Hotel(res);
//		hotel.reserveRestaurant();
		
		//스프링 방법
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:test-config.xml");

		Hotel hotel = ct.getBean("hotel", Hotel.class);
		hotel.reserveRestaurant();
		
	}
}
