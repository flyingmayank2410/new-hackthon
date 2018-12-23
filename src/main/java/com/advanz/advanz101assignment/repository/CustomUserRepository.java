/**
 * 
 */
package com.advanz.advanz101assignment.repository;

import org.springframework.stereotype.Repository;

import com.advanz.advanz101assignment.model.UserDetails;

/**
 * @author Mayank
 *
 */
@Repository
public interface CustomUserRepository {

	public UserDetails findUserByMailId(String mailId);
}
