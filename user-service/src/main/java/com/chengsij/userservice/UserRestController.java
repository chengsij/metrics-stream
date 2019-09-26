package com.chengsij.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserRestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/personalized/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "personalizedFallback")
    public Movie[] personalized(@PathVariable int id) {
        Movie[] result = restTemplate.getForObject("http://recommendation-service/user/recommendations", Movie[].class);
        return result;
    }

    @GetMapping(value = "/movies")
    @ResponseBody
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value ="500"),
            @HystrixProperty(name = "circuitBreaker.forceClosed", value ="true"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value ="20")
    })
    public Movie[] getMovies() {
        Movie[] result = restTemplate.getForObject("http://recommendation-service/user/recommendations", Movie[].class);
        return result;
    }

    public Movie[] personalizedFallback(int id){
        return new Movie[0];
    }
}
