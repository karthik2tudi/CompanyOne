package com.rt.target;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rt.dependent.BlueDartAgent;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Order(-4)
public class Amazon {
	
	@Autowired
	private BlueDartAgent blueDart;
	
	
	@Value("${isAmazon.value}")
	private boolean flagValue;
	
	
	@PostConstruct
	public void init() {
		System.out.println(flagValue);
		System.out.println(blueDart.hashCode());
	}


	public String checkDeliveryAvalability(String pincode) {
			String availability= blueDart.checkDelihveryStatusWithPincode(pincode);
			return availability;
	}

	@PreDestroy
	public void destroy() {
		System.out.println("object is about to destroy");
	}

	
}
