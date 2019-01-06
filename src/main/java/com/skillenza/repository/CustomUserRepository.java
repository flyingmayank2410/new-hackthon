/**
 * 
 */
package com.skillenza.repository;

import org.springframework.stereotype.Repository;

import com.skillenza.model.UserDetails;

/**
 * @author Mayank
 *
 */
@Repository
public interface CustomUserRepository {

	public UserDetails findUserByMailId(String mailId);
}
