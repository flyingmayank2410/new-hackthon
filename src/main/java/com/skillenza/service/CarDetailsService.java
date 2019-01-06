/**
 * 
 */
package com.skillenza.service;

import java.util.List;
import java.util.Optional;

import com.skillenza.model.CarDetails;
import com.skillenza.request.CarDetailsForm;

/**
 * @author Mayank
 *
 */
public interface CarDetailsService {
	
	public CarDetails registerCar(CarDetailsForm carDetailsForm);

	public List<CarDetails> getAllCars();

	public Optional<CarDetails> getCarById(long id);

}
