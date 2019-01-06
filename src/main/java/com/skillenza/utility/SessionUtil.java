package com.skillenza.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil {
	
	public static long getLoggedInUserId() {
		ServletRequestAttributes attributes =
			(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		if (attributes == null) {
			return 0;
		}
		HttpServletRequest request = attributes.getRequest();
		String userId = (String) request.getAttribute("userId");
	
		if (userId == null) {
			// Temp setup for Swagger access
			return 0;
		}else {
			return Long.valueOf(userId);
		}
	}

}
