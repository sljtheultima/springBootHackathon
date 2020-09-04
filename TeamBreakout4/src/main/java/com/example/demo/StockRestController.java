package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stocks")
@CrossOrigin
@ConfigurationProperties(prefix="api")
public class StockRestController {
    RestTemplate template = new RestTemplate();

    @Autowired
    ApiProperties apiProperties;

    @GetMapping(value = "/getSummary")
    public String getStocksData(@RequestParam("username") String username){
        HttpHeaders headers = new HttpHeaders();
        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-summary?region=US&lang=en";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(apiProperties.getKey_name(), apiProperties.getKey_value());
        headers.add(apiProperties.getHost_name(),apiProperties.getHost_value());
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(responseEntity.getBody());
        return "";




    }

}
