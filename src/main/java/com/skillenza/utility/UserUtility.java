/**
 * 
 */
package com.skillenza.utility;

import java.sql.ResultSet;

import com.skillenza.model.UserDetails;

/**
 * @author Mayank
 *
 */
public class UserUtility {

	public static UserDetails getValueFromResultSet(ResultSet resultSet) {
		UserDetails userDetails = null;
		try {
			if (userDetails == null) {
				userDetails = new UserDetails();
			}
			userDetails.setUserId(resultSet.getInt(1));
			userDetails.setUserName(resultSet.getString("user_email"));
			userDetails.setFirstName(resultSet.getString("first_name"));
			userDetails.setLastName(resultSet.getString("last_name"));
			userDetails.setPassword(resultSet.getString("user_passowrd"));
			userDetails.setContactNo(resultSet.getString("contact_no"));
			userDetails.setAddress(resultSet.getString("user_address"));
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return userDetails;

	}
}
