package com.skillenza.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.skillenza.model.CarDetails;
import com.skillenza.service.CarDetailsService;

@Configuration
@EnableScheduling
public class AppConfig {

	@Autowired
	CarDetailsService  carDetailsService;
	
	@Scheduled(fixedRate=3000)
	public List<CarDetails> getAllCarDetailsDynamically(){
		List<CarDetails> list = carDetailsService.getAllCars();
		System.out.println(Collections.singleton(list));
		return list;
	}
}
