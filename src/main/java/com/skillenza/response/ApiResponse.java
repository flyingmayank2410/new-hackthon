/**
 * 
 */
package com.skillenza.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mayank
 *
 */
public class ApiResponse {

	/** The success object. */
	private Map<String, Object> successObject = new HashMap<String, Object>();

	/** The failed object. */
	private Map<String, Object> failedObject = new HashMap<String, Object>();

	/**
	 * Sets the success result.
	 *
	 * @param object
	 *            the new success result
	 */
	public void setSuccessResult(Object object) {
		
		successObject.put("status_message", "SUCCESS");
		successObject.put("status_code", 200);
		if(object != null) {
			successObject.put("result", object);	
		}
	}

	/**
	 * Gets the success object.
	 *
	 * @return the success object
	 */
	public Map<String, Object> getSuccessObject() {
		return successObject;
	}

	/**
	 * Sets the failed result.
	 *
	 * @param object
	 *            the new failed result
	 */
	public void setFailedResult(int statusCode, String statusMessage, Object object) {
		failedObject.put("status_message", statusMessage);
		failedObject.put("status_code", statusCode);
		if(object != null) {
			failedObject.put("result", object);	
		}
		
	}
	
	public void setFailedResult(int statusCode, String statusMessage) {
		failedObject.put("status_message", statusMessage);
		failedObject.put("status_code", statusCode);
		
		
	}

	/**
	 * Gets the failed object.
	 *
	 * @return the failed object
	 */
	public Map<String, Object> getFailedObject() {
		return failedObject;
	}

}
