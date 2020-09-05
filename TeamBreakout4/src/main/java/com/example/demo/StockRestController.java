package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stocks")
@CrossOrigin
@ConfigurationProperties(prefix="api")
public class StockRestController {


    @Autowired
    HttpBuilder httpBuilder;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/getEarnings")
    public ResponseEntity<JsonNode> getEarningsData(@RequestParam Map<String,String> allRequestParams) throws JsonProcessingException {

        if(isAuthenticated(allRequestParams))
        {
            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("size", "10");
            queryParams.add("region", "US");

            String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-earnings?startDate=1585155600000&endDate=1589475600000";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()));
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);


    }

    @GetMapping("/historicalData")
   public ResponseEntity<JsonNode> getHistoricalData(@RequestParam Map<String,String> allRequestParams) throws JsonProcessingException {

        if(isAuthenticated(allRequestParams))
        {
            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("period1", "154648400");
            queryParams.add("period2", "1562086800");
            queryParams.add("symbol","AMRN");

            String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-historical-data";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()));
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    public boolean isAuthenticated(Map<String,String> requestParams)
    {
        return requestParams.containsKey("username") && userRepository.findUserByUsername(requestParams.get("username")).size()>0;
    }




}
