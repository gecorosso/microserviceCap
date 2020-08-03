package com.codicefiscale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.codicefiscale.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestController.class)
@ComponentScan({"com.codicefiscale"})

public class MicroserviceCapApplication {
	static final Logger log = LoggerFactory.getLogger(MicroserviceCapApplication.class);
	
	//localhost / 127.0.0.1 / capdb
	
	public static void main(String[] args) {
		log.info("Dentro al main");
		
		SpringApplication.run(MicroserviceCapApplication.class, args);
	}

}
