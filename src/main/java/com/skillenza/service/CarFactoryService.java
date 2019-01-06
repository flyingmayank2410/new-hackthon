/**
 * 
 */
package com.skillenza.service;

import java.util.List;

import com.skillenza.model.CarFactory;
import com.skillenza.request.CarFactoryForm;

/**
 * @author Mayank
 *
 */
public interface CarFactoryService {
	
	public CarFactory registerCars(CarFactoryForm carFactoryForm);
	
	public List<CarFactory> getAllCars();

}
