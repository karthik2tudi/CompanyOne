package com.rt.dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.rt.constant.ServiceConstant;
import com.rt.target.Amazon;

@Component
public class BlueDartAgent {


	public String checkDelihveryStatusWithPincode(String pincode) {
		
		if(ServiceConstant.PINCODE_HYD.equalsIgnoreCase(pincode)) {
		//if(pincode.equalsIgnoreCase("509001")) {
			return "it's an Hyderabad address and can Delivere the item";
		}
		else if("509380".equalsIgnoreCase(pincode)) {
			return  "looks it is remote address we can not delivere currently";
		}else if ("309003".equalsIgnoreCase(pincode)) {
			return  "it's an Mumbai address and can Delivere the item";
		}else if ("204033".equalsIgnoreCase(pincode)) {
			return  "it's an Delhi address and can Delivere the item";
		}
		else {
			return "please enter correct pincode";
		}
	}
	
}
