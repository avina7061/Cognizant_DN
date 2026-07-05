package com.SpringLearn.SpringREST_Handson_2.handson2.service;


import java.util.List;

import com.SpringLearn.SpringREST_Handson_2.handson2.exception.CountryNotFoundException;
import com.SpringLearn.SpringREST_Handson_2.handson2.model.Country;

public interface CountryService {

    Country getCountry(String code) throws CountryNotFoundException;

    List<Country> getAllCountries();

}