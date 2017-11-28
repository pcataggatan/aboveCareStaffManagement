package edu.matc.com.zipcodeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * This class represents the data items that the zipcode api returns for the zipcodes that are found
 * within a given zipcode and a radius. The items include the zipcode, distance, city and state.
 *
 * This code was generated via RoboPJO generator plugin in Intelligj.
 *
 * @author: Pablo Cataggatan
 */
@Generated("com.robohorse.robopojogenerator")
public class ZipCodesItem{

	@JsonProperty("distance")
	private double distance;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip_code")
	private String zipCode;

	/**
	 * Sets the value of the distance attribute.
	 * @param distance The distance from a given zipcode and radius.
	 */
	public void setDistance(double distance){
		this.distance = distance;
	}


	/**
	 * Gets the value of the distance attribute.
	 * @return The value of the distance.
	 */
	public double getDistance(){
		return distance;
	}

	/**
	 * Sets the value of the city attribute.
	 * @param city The city found from a given zipcode and radius.
	 */
	public void setCity(String city){
		this.city = city;
	}

	/**
	 * Gets the value of the city attribute.
	 * @return The value of the city.
	 */
	public String getCity(){
		return city;
	}

	/**
	 * Sets the value of the state attribute.
	 * @param state The state code found from a given zipcode and radius.
	 */
	public void setState(String state){
		this.state = state;
	}

	/**
	 * Gets the value of the state atrtibute.
	 * @return The value of the state code.
	 */
	public String getState(){
		return state;
	}

	/**
	 * Sets the value of the zipcode attribute.
	 * @param zipCode The zipcode found from a given zipcode and radius.
	 */
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	/**
	 * Gets the vakue of the zipcode attribute.
	 * @return The value of the zipcode.
	 */
	public String getZipCode(){
		return zipCode;
	}

	/**
	 * Values of the data items from the zipcode api.
	 * @return A string containing the values of the data items.
	 */
	@Override
 	public String toString(){
		return 
			"ZipCodesItem{" + 
			"distance = '" + distance + '\'' + 
			",city = '" + city + '\'' + 
			",state = '" + state + '\'' + 
			",zip_code = '" + zipCode + '\'' + 
			"}";
		}
}