package com.SpringLearn.SpringREST_Handson_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringRestHandson1Application {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringRestHandson1Application.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringRestHandson1Application.class, args);

		LOGGER.info("Application Started");

		displayDate();

		displayCountry();

		displayCountries();

		LOGGER.info("Application Finished");
	}

	// ==========================
	// Hands-on 2
	// ==========================

	public static void displayDate() {

		LOGGER.info("START displayDate()");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format =
				context.getBean("dateFormat", SimpleDateFormat.class);

		try {

			Date date = format.parse("31/12/2018");

			LOGGER.debug("Parsed Date : {}", date);

		} catch (Exception e) {

			LOGGER.error("Exception : {}", e.getMessage());

		}

		LOGGER.info("END displayDate()");
	}

	// ==========================
	// Hands-on 4 & 5
	// ==========================

	public static void displayCountry() {

		LOGGER.info("START displayCountry()");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =
				context.getBean("in", Country.class);

		LOGGER.debug("Country : {}", country);

		// Singleton Demo
		Country anotherCountry =
				context.getBean("in", Country.class);

		LOGGER.debug("Second Bean : {}", anotherCountry);

		if (country == anotherCountry) {

			LOGGER.debug("Singleton Scope : Same Object");

		} else {

			LOGGER.debug("Prototype Scope : Different Objects");

		}

		LOGGER.info("END displayCountry()");
	}

	// ==========================
	// Hands-on 6
	// ==========================

	@SuppressWarnings("unchecked")
	public static void displayCountries() {

		LOGGER.info("START displayCountries()");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries =
				(List<Country>) context.getBean("countryList");

		for (Country country : countries) {

			LOGGER.debug("{}", country);

		}

		LOGGER.info("END displayCountries()");
	}

}