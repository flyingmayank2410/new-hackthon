/**
 * 
 */
package com.skillenza.validation;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


/**
 * @author Mayank
 *
 */
public class UserCredentialsVlaidation {

	public static boolean isValidMail(String mailId) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(mailId);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

}
