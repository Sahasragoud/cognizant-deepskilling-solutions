package com.jwt.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<String> getCountries() {

        return List.of(
                "India",
                "USA",
                "Japan",
                "Australia",
                "Germany"
        );
    }
}
