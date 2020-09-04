package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@CrossOrigin
@ConfigurationProperties(prefix="api")
public class StockRestController {
    RestTemplate template = new RestTemplate();

    @Autowired
    ApiProperties apiProperties;

    @GetMapping(value = "/getEarnings")
    public ResponseEntity<Earnings> getEarningsData(@RequestParam("username") String username){
        HttpHeaders headers = new HttpHeaders();
        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-earnings?size=10&region=US&startDate=1585155600000&endDate=1589475600000";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(apiProperties.getKey_name(), apiProperties.getKey_value());
        headers.add(apiProperties.getHost_name(),apiProperties.getHost_value());
        ParameterizedTypeReference<List<Earnings>> responseType =
                new ParameterizedTypeReference<List<Earnings>>() {};


        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Earnings> responseEntity = template.exchange(url, HttpMethod.GET,entity,Earnings.class);
        System.out.println(responseEntity.getBody());
        return responseEntity;

    }

}
