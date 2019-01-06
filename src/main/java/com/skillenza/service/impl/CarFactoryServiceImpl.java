/**
 * 
 */
package com.skillenza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillenza.model.CarFactory;
import com.skillenza.repository.CarFactoryRepository;
import com.skillenza.request.CarFactoryForm;
import com.skillenza.service.CarFactoryService;

/**
 * @author Mayank
 *
 */
@Service
public class CarFactoryServiceImpl implements CarFactoryService {

	@Autowired
	CarFactoryRepository carFactoryRepository;

	@Override
	public CarFactory registerCars(CarFactoryForm carFactoryForm) {
		CarFactory carFactory = null;
		if (carFactoryForm != null) {
			if (carFactory == null) {
				carFactory = new CarFactory();
			}
			carFactory.setCarModel(carFactoryForm.getCarModel());
			carFactory.setCarPrice(carFactoryForm.getPrice());

			carFactory = carFactoryRepository.save(carFactory);
		}

		return carFactory;
	}

	@Override
	public List<CarFactory> getAllCars() {

		return (List<CarFactory>) carFactoryRepository.findAll();
	}

}
