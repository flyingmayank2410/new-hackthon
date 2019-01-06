/**
 * 
 */
package com.skillenza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillenza.model.UserDetails;

/**
 * @author Mayank
 *
 */
@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

	
}
