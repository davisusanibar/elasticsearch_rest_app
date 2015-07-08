package vz.log.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value={"log-elastic-config.xml"})
public class LogElasticBoot {

	public static void main(String[] args) {
		SpringApplication.run(LogElasticBoot.class, args);
	}	
}
