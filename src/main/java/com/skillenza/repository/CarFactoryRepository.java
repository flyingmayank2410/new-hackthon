/**
 * 
 */
package com.skillenza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillenza.model.CarFactory;

/**
 * @author Mayank
 *
 */
@Repository
public interface CarFactoryRepository extends CrudRepository<CarFactory, Long>{

	
}
