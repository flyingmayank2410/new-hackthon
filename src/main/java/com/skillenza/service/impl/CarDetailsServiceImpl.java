/**
 * 
 */
package com.skillenza.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillenza.model.CarDetails;
import com.skillenza.repository.CarDetailsRepository;
import com.skillenza.request.CarDetailsForm;
import com.skillenza.service.CarDetailsService;

/**
 * @author Mayank
 *
 */
@Service
public class CarDetailsServiceImpl implements CarDetailsService {

	@Autowired
	CarDetailsRepository carDetailsRepository;

	@Override
	public CarDetails registerCar(CarDetailsForm carDetailsForm) {
		CarDetails carDetails = null;
		if (carDetailsForm != null) {
			if (carDetails == null) {
				carDetails = new CarDetails();
			}
			carDetails.setCarModel(carDetailsForm.getCarModel());
			carDetails.setMaxbidPrice(carDetailsForm.getBidPrice());
		}

		carDetails = carDetailsRepository.save(carDetails);
		return carDetails;
	}

	@Override
	public List<CarDetails> getAllCars() {
	//	Iterable<CarDetails> ltr = carDetailsRepository.findAll();
		return (List<CarDetails>) carDetailsRepository.findAll();
	}

	@Override
	public Optional<CarDetails> getCarById(long id) {
		
		return carDetailsRepository.findById(id);
	}

}
