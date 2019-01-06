/**
 * 
 */
package com.skillenza.request;

/**
 * @author Mayank
 *
 */
public class CarDetailsForm {

	private long id;
	
	private String carModel;
	
	private double bidPrice;

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
