/**
 * 
 */
package com.skillenza.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.skillenza.model.UserDetails;
import com.skillenza.request.CarDetailsForm;
import com.skillenza.request.UserDetailsForm;

/**
 * @author Mayank
 *
 */
public interface UserDetailsService {
	
	boolean isExist(long id);
	
	Optional<UserDetails> findById(long id);

	Map<String, UserDetails> save(UserDetailsForm userDetailsForm);

	Map<String, List<UserDetails>> saveListOfUsers(List<UserDetailsForm> userDetailsFormList);

	List<UserDetails> findAll();
	
	public UserDetails findUserByMailId(String mailId);

	Map<String, UserDetails> loginUser(String mailId, String password);

	void bed(CarDetailsForm carDetailsForm);

}
