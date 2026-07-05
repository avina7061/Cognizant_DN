package com.SpringLearn.SpringREST_Handson_2.handson2.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.SpringLearn.SpringREST_Handson_2.handson2.exception.CountryNotFoundException;
import com.SpringLearn.SpringREST_Handson_2.handson2.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryServiceImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("handson2/country.xml");

        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        LOGGER.info("END");

        return countries;
    }

    @Override
    public Country getCountry(String code) throws CountryNotFoundException {

        LOGGER.info("START");

        List<Country> countries = getAllCountries();

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {

                LOGGER.info("END");

                return country;
            }
        }

        throw new CountryNotFoundException();
    }

}