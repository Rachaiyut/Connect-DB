package com.example.connecDB;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
 
@SpringBootApplication
public class ConnecDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnecDbApplication.class, args);
	}

	@Bean  
	public CorsFilter corsFilter() {   
		CorsConfiguration corsConfiguration = new CorsConfiguration();   
		corsConfiguration.setAllowCredentials(true);   
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));   
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-AllowOrigin","Content-Type","Accept", "Authorization","Origin,Accept","X-Requested-With","AccessControl-Request-Method","Access-Control-Request-Headers"));   
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Access-Control-AllowOrigin","Content-Type","Accept", "Authorization","Access-Control-Allow-Credentials"));   
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));   
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();   
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);   
		return new CorsFilter(urlBasedCorsConfigurationSource);  } 

}
