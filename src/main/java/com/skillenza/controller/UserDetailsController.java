package com.skillenza.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.skillenza.model.CarFactory;
import com.skillenza.model.UserDetails;
import com.skillenza.request.CarDetailsForm;
import com.skillenza.request.UserDetailsForm;
import com.skillenza.response.ApiResponse;
import com.skillenza.service.CarFactoryService;
import com.skillenza.service.UserDetailsService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Mayank
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	CarFactoryService carFactoryService;

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

	@PostMapping("/register")
	@ApiOperation(tags = "Users Operations", nickname = "Signup", value = "Register User Details", httpMethod = "POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> registerUser(
			@RequestBody final UserDetailsForm userDetailsForm) {

		logger.info("Invoked");
		ApiResponse apiResponse = new ApiResponse();
		Map<String, UserDetails> responseMap = null;
		if (userDetailsForm != null)
			responseMap = userDetailsService.save(userDetailsForm);
		String message = responseMap.entrySet().iterator().next().getKey();
		if (responseMap.get(message) == null) {
			apiResponse.setFailedResult(402, responseMap.entrySet().iterator().next().getKey(), null);
			return new ResponseEntity<Map<String, Object>>(apiResponse.getFailedObject(), HttpStatus.FORBIDDEN);
		}
		logger.info("Successded");
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	@ApiOperation(tags = "Users Operations", nickname = "findUserById", value = "Get user details by id", httpMethod = "GET")
	public Optional<UserDetails> findUserById(@PathVariable(value = "id") final long id) {
		logger.info("Invoked");
		Optional<UserDetails> userDetails = null;
		if (id > 0) {
			userDetails = userDetailsService.findById(id);
		}
		logger.info("Mayank");
		return userDetails;

	}

	@PostMapping("/save/list")
	@ApiOperation(tags = "Users Operations", nickname = "saveUser", value = "Save user details", httpMethod = "POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> saveUserList(
			@RequestBody final List<UserDetailsForm> userDetailsFormList) {
		Map<String, List<UserDetails>> responseMap = null;
		ApiResponse apiResponse = new ApiResponse();
		if (userDetailsFormList != null && userDetailsFormList.size() > 0)
			responseMap = userDetailsService.saveListOfUsers(userDetailsFormList);
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);

	}

	@GetMapping("/all")
	@ApiOperation(tags = "Users Operations", nickname = "getAllUsers", value = "Get all user details", httpMethod = "GET")
	public List<UserDetails> findUserById() {
		List<UserDetails> userDetailsList = userDetailsService.findAll();
		return userDetailsList;
	}

	@GetMapping("/signin/{mailId}/{password}")
	@ApiOperation(tags = "Users Operations", nickname = "SignIn", value = "Login User", httpMethod = "GET")
	public @ResponseBody ResponseEntity<Map<String, Object>> signIn(@PathVariable final String mailId,
			@PathVariable final String password) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, UserDetails> responseMap = userDetailsService.loginUser(mailId, password);
		String message = responseMap.entrySet().iterator().next().getKey();
		if (responseMap.get(message) == null) {
			apiResponse.setFailedResult(402, message, null);
			return new ResponseEntity<Map<String, Object>>(apiResponse.getFailedObject(), HttpStatus.FORBIDDEN);
		}
		List<CarFactory> cars = carFactoryService.getAllCars();
		apiResponse.setSuccessResult(cars);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);
	}
	
	@PostMapping("/bidding")
	@ApiOperation(tags = "Users Operations", nickname = "saveUser", value = "Save user details", httpMethod = "POST")
	public @ResponseBody ResponseEntity<Map<String, Object>> bed(
			@RequestBody final CarDetailsForm carDetailsForm) {
		Map<String, List<UserDetails>> responseMap = null;
		ApiResponse apiResponse = new ApiResponse();
		if (carDetailsForm != null)
			userDetailsService.bed(carDetailsForm);
		apiResponse.setSuccessResult(responseMap);
		return new ResponseEntity<Map<String, Object>>(apiResponse.getSuccessObject(), HttpStatus.OK);

	}

}
