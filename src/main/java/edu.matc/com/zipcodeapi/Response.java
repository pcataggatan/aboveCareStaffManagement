package edu.matc.com.zipcodeapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * This is the response class from the zipcodesapi webservice.
 * This code is generated via RoboPOJO generator plugin in Intellij.
 *
 * @author Pablo Cataggatan
 */
@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	/**
	 * Sets the zipCodes attribiute.
	 * @param zipCodes List of zip codes within a given radius.
	 */
	public void setZipCodes(List<ZipCodesItem> zipCodes){
		this.zipCodes = zipCodes;
	}


	/**
	 * Gets the the list of zipcodes within a given radius.
	 * @return The list of zipcodes within a given radius.
	 */
	public List<ZipCodesItem> getZipCodes() {
		return zipCodes;
	}

	/**
	 * Concatenates the values of the attributes into a string.
	 * @return A string containing the values of the response attributes.
	 */
	@Override
 	public String toString(){
		return 
			"Response{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";
		}
}