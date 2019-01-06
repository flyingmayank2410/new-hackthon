/**
 * 
 */
package com.skillenza.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "user_email")
	@Email(message = "Please enter a valid mail id")
	@NotEmpty(message = "Please enter a mail")
	@NotNull
	private String userName;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "first_name")
	@NotEmpty(message = "First name is mandatory")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Last name is mandatory")
	private String lastName;

	@Column(name = "user_passowrd")
	@NotEmpty(message = "Please enter a password")
	@Length(min = 5, message = "Your password must have 5 character")
	private String password;

	@Column(name = "user_address")
	private String address;
	
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private Set<CarDetails> carDetails;
	
	/*@Column(name = "is_active")
	private boolean isActive;*/
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<CarDetails> getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(Set<CarDetails> carDetails) {
		this.carDetails = carDetails;
	}
}
