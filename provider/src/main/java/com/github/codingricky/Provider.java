package com.github.codingricky;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class Provider {

    @RequestMapping(method= RequestMethod.GET, value = "/customer/{id}")
    public String index(@PathVariable int id) {
        return String.format("hello from the other side %s", id);
    }

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }
}
