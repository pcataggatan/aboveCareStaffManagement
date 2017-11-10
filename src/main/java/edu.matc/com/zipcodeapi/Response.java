package edu.matc.com.zipcodeapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	public void setZipCodes(List<ZipCodesItem> zipCodes){
		this.zipCodes = zipCodes;
	}

	public List<ZipCodesItem> getZipCodes() {
		return zipCodes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";
		}
}