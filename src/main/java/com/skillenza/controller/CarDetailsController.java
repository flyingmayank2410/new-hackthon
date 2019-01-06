/**
 * 
 */
package com.skillenza.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillenza.model.CarFactory;
import com.skillenza.request.CarFactoryForm;
import com.skillenza.response.ApiResponse;
import com.skillenza.service.CarDetailsService;
import com.skillenza.service.CarFactoryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Mayank
 *
 */

@RestController
@RequestMapping("/car")
public class CarDetailsController {
	
	@Autowired
	CarDetailsService carDetailsService;
	
	@Autowired
	CarFactoryService carFactoryService;

	@PostMapping("/register")
	@ApiOperation(tags = "Car Operations", nickname = "register", value = "Register Car Details", httpMethod = "POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> registerCar(
			@RequestBody final CarFactoryForm carFactoryForm) {
	
		ApiResponse apiResponse = new ApiResponse();
	//	CarDetails carDetails = carDetailsService.registerCar(carDetailsForm);
		
		CarFactory carFactory = carFactoryService.registerCars(carFactoryForm);
		apiResponse.setSuccessResult(carFactory);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	@ApiOperation(tags = "Car Operations", nickname = "get all cars details", value = "get all Car Details", httpMethod = "GET")
	public @ResponseBody ResponseEntity<Map<String, Object>> getAllCarDetails() {
	
		ApiResponse apiResponse = new ApiResponse();
		 
		apiResponse.setSuccessResult(carFactoryService.getAllCars());
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
		
	}
	
	
}
