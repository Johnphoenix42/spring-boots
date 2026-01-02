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
		Customer bilboBaggins = new Customer("Bilbo", "Baggins" );
		Customer itachiUchiha = new Customer("Itachi", "Uchiha");
		Customer erenYeager = new Customer("Eren", "Yeager");
		Customer leviAckerman = new Customer("Levi", "Ackerman");
		return args -> {
			logger.info("Preloading " + repository.save(bilboBaggins));
			logger.info("Preloading " + repository.save(itachiUchiha));
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
