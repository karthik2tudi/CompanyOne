package com.rt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.target.Amazon;


@SpringBootApplication
public class MySecondSpringBootAppApplication {
	
	
	@Bean
	@Order
	public ObjectMapper createMapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(MySecondSpringBootAppApplication.class, args);
		Amazon bean = (Amazon)ct.getBean("amazon");
		//calling target class method on target class object.
		String msg = bean.checkDeliveryAvalability("509001");
		System.out.println(msg);
		((ConfigurableApplicationContext) ct).close();
		
	}

}
