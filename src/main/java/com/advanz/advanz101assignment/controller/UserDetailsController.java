package com.advanz.advanz101assignment.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.advanz.advanz101assignment.model.UserDetails;
import com.advanz.advanz101assignment.request.UserDetailsForm;
import com.advanz.advanz101assignment.response.ApiResponse;
import com.advanz.advanz101assignment.service.UserDetailsService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Mayank
 *
 */
@RestController
@RequestMapping("/users")
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/register")
	@ApiOperation(tags = "Users Operations",nickname="Signup", value = "Register User Details", httpMethod="POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> registerUser(@RequestBody final UserDetailsForm userDetailsForm) {
		
		
		ApiResponse apiResponse = new ApiResponse();
		Map<String, UserDetails> responseMap = null;
		if(userDetailsForm != null)
			responseMap = userDetailsService.save(userDetailsForm);
		String message = responseMap.entrySet().iterator().next().getKey();
		if (responseMap.get(message) == null) {
			apiResponse.setFailedResult(402, responseMap.entrySet().iterator().next().getKey(), null);
			return new ResponseEntity<Map<String, Object>>(apiResponse.getFailedObject(), HttpStatus.FORBIDDEN);
		}
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(tags = "Users Operations",nickname="findUserById", value = "Get user details by id", httpMethod="GET")
	public Optional<UserDetails> findUserById(@PathVariable(value="id") final long id) {
		Optional<UserDetails> userDetails  = null;
		if(id > 0) {
		 userDetails = userDetailsService.findById(id);
		}
		return userDetails;
		
	}
	
	@PostMapping("/save/list")
	@ApiOperation(tags = "Users Operations",nickname="saveUser", value = "Save user details", httpMethod="POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> saveUserList(@RequestBody final List<UserDetailsForm> userDetailsFormList) {
		Map<String, List<UserDetails>> responseMap = null;
		ApiResponse apiResponse = new ApiResponse();
		if(userDetailsFormList != null && userDetailsFormList.size() > 0)
			responseMap = userDetailsService.saveListOfUsers(userDetailsFormList);
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	@ApiOperation(tags = "Users Operations",nickname="getAllUsers", value = "Get all user details", httpMethod="GET")
	public List<UserDetails> findUserById() {
		List<UserDetails> userDetailsList = userDetailsService.findAll();
		return userDetailsList;
	}

	@GetMapping("/signin/{mailId}/{password}")
	@ApiOperation(tags = "Users Operations",nickname="SignIn", value = "Login User", httpMethod="GET")
	public @ResponseBody ResponseEntity<Map<String, Object>> signIn(@PathVariable final String mailId, 
			@PathVariable final String password){
		ApiResponse apiResponse = new ApiResponse();
		Map<String, UserDetails> responseMap = userDetailsService.loginUser(mailId, password);
		String message = responseMap.entrySet().iterator().next().getKey();
		if (responseMap.get(message) == null) {
			apiResponse.setFailedResult(402, message, null);
			return new ResponseEntity<Map<String, Object>>(apiResponse.getFailedObject(), HttpStatus.FORBIDDEN);
		}
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
	}
	
}
