/**
 * 
 */
package com.skillenza.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name = "car_details")
public class CarDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long carId;
	
	@Column(name = "car_model")
	private String carModel;
	
	@Column(name = "max_bid_price")
	private double maxbidPrice;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;
	
	/*@Column(name = "is_active")
	private boolean isActive;*/
	
	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getMaxbidPrice() {
		return maxbidPrice;
	}

	public void setMaxbidPrice(double maxbidPrice) {
		this.maxbidPrice = maxbidPrice;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "CarDetails [carId=" + carId + ", carModel=" + carModel + ", maxbidPrice=" + maxbidPrice
				+ ", userDetails=" + userDetails + "]";
	}

}
