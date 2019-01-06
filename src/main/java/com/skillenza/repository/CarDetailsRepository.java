/**
 * 
 */
package com.skillenza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillenza.model.CarDetails;

/**
 * @author Mayank
 *
 */
@Repository
public interface CarDetailsRepository extends CrudRepository<CarDetails, Long> {

}
