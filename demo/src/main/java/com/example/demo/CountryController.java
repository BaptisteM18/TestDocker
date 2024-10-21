package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    private List<Country> countries = new ArrayList<>();

    @GetMapping("/countries")
    //https://localhost:8090/countries
    public ResponseEntity<List<Country>> countries(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(countries);
    }

    @GetMapping("/country")
    //https://localhost:8090/country?id=1
    public ResponseEntity<Country> country(@RequestParam int id){
        for (Country country : countries) {
            if (country.getId() == id) {
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(country);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @PostMapping("/country")
    //https://localhost:8090/country
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        countries.add(country);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Country added: " + country.getName());
    }

    @DeleteMapping("/country/{id}")
    //https://localhost:8090/country/1
    public ResponseEntity<String> deleteCountry(@PathVariable int id) {
        for (Country country : countries) {
            if (country.getId() == id) {
                countries.remove(country);
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body("Country with id " + id + " deleted");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Country with id " + id + " not found");
    }


}
