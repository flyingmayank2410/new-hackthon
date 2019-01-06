/**
 * 
 */
package com.skillenza.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.skillenza.model.UserDetails;
import com.skillenza.repository.CustomUserRepository;
import com.skillenza.utility.ConnectionUtility;
import com.skillenza.utility.UserUtility;

/**
 * @author Mayank
 *
 */
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
	
	/* (non-Javadoc)
	 * @see com.advanz.advanz101assignment.repository.CustomRepository#findUserByMailId(java.lang.String)
	 */
	@Override
	public UserDetails findUserByMailId(String mailId) {
		final String sql = "select * from user_details where user_email=" + "'" + mailId + "'";
		Statement statement = null;
		ResultSet resultSet = null;
		UserDetails userDetails = null;

		statement = ConnectionUtility.getConnection();

		if (statement != null)
			try {
				resultSet = statement.executeQuery(sql);
				if (resultSet != null)
					while (resultSet.next()) {
						userDetails = UserUtility.getValueFromResultSet(resultSet);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return userDetails;
	}

}
