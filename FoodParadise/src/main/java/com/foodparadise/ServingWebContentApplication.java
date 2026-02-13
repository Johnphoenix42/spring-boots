package com.foodparadise;

import com.foodparadise.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentApplication {

	private Logger logger = LoggerFactory.getLogger(ServingWebContentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(CustomerRepository repository) {
		Customer bilboBaggins = new Customer("johnworkbackup042@gmail.com", "flipperachi", "Bilbo", "Baggins" );
		Customer chojiAkimichi = new Customer("johnolamide420@gmail.com", "flipperachi", "Itachi", "Uchiha");
		Customer erenYeager = new Customer("jstrings619@gmail.com", "flipperachi", "Eren", "Yeager");
		Customer leviAckerman = new Customer("acedigitalco101@gmail.com", "flipperachi", "Levi", "Ackerman");
		return args -> {
			logger.info("Preloading " + repository.save(bilboBaggins));
			logger.info("Preloading " + repository.save(chojiAkimichi));
			logger.info("Preloading " + repository.save(erenYeager));
			logger.info("Preloading " + repository.save(leviAckerman));

			logger.info("Customers found using findALl: ");
			logger.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				logger.info("Using findAll" + customer.toString());
			});
		};
	}

}
