package com.SpringLearn.SpringREST_Handson_2.handson2.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringLearn.SpringREST_Handson_2.handson2.exception.CountryNotFoundException;
import com.SpringLearn.SpringREST_Handson_2.handson2.model.Country;
import com.SpringLearn.SpringREST_Handson_2.handson2.service.CountryService;

@RestController
@RequestMapping("/handson2")
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("handson2/country.xml");

        Country country = context.getBean("in", Country.class);

        LOGGER.info("END");

        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(
            @PathVariable String code)
            throws CountryNotFoundException {

        LOGGER.info("START");

        Country country =
                countryService.getCountry(code);

        LOGGER.info("END");

        return country;
    }

}