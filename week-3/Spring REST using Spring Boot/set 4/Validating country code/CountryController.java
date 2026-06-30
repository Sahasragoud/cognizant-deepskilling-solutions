package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import jakarta.validation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.cognizant.spring_learn.SpringLearnApplication.LOGGER;

@RequestMapping("/countries")
@RestController
public class CountryController {

    private final CountryService countryService;
    private final Validator validator;

    public CountryController(CountryService countryService, Validator validator) {
        this.countryService = countryService;
        this.validator = validator;
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(
            @PathVariable String code
    ) {
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(
            @RequestBody Country country
    ) {
        LOGGER.info("start");
        //This application uses 4.1.0 version of spring boot
        //So we do not need to create manual build factories.
        Set<ConstraintViolation<Country>> violations = validator.validate(country);

        if(!violations.isEmpty()){
            List<String> errors = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());

            LOGGER.error("Validation failed : {}", errors);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }

        LOGGER.debug("Country : {}" , country);
        LOGGER.info("end");
        return country;
    }

}
