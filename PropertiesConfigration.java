package com.si;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration

@ComponentScan(value = { "com.si" })
@PropertySource(value = { "classpath:application.properties" })
public class PropertiesConfigration {

	public static final String baseURL = "baseURL";


	public static String baseURLT;;
	

	@Autowired
	private Environment env;
	

	@Bean
	public String PropertiesConfigrationResult() {

	
		baseURLT = env.getProperty(baseURL);

		return baseURLT;
	}

}
