package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/finance")
@CrossOrigin

public class FinancialRestController {


    @Autowired
    HttpBuilder httpBuilder;

    @Autowired
    UserService userService;

    @GetMapping(value = "/market/getEarnings",produces = {"application/json","application/xml"})
    public ResponseEntity<JsonNode> getEarningsData(@RequestParam Map<String,String> allRequestParams,@RequestHeader("username") String username) throws JsonProcessingException {

        if(isAuthenticated(username))
        {
            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("startDate", "1585155600000");
            queryParams.add("endDate","1589475600000");
            queryParams.add("region", "US");

            String url = "/market/get-earnings";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()).path("finance").path("result"));
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);


    }

    @GetMapping(value= "/market/getPopularWatchlist",produces = {"application/json","application/xml"})
    public ResponseEntity<JsonNode> getPopularList(@RequestHeader(value = "username",required = true)  String username) throws JsonProcessingException {
        if(isAuthenticated(username)){
            String url = "/market/get-popular-watchlists";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(url).toUriString()).path("finance").path("result"));
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);

    }

    @GetMapping(value = "/stock/historicalData",produces = {"application/json","application/xml"})
   public ResponseEntity<JsonNode> getHistoricalData(@RequestParam Map<String,String> allRequestParams,@RequestHeader("username") String username) throws JsonProcessingException {

        if(isAuthenticated(username))
        {
            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("period1", "154648400");
            queryParams.add("period2", "1562086800");
            queryParams.add("symbol","AMRN");

            String url = "/stock/v2/get-historical-data";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()));
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @GetMapping(value = "/stock/news",produces = {"application/json","application/xml"})
    public ResponseEntity<JsonNode> getStockNews(@RequestParam Map<String,String> allRequestParams,@RequestHeader("username") String username) throws JsonProcessingException {
        if(isAuthenticated(username)){
            MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("region","US");
            queryParams.add("category","NBEV");

            String url = "/stock/get-news";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()).path("items").path("result"));
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @GetMapping(value = "/news",produces = {"application/json","application/xml"})
    public ResponseEntity<JsonNode> getNews(@RequestParam Map<String,String> allRequestParams,@RequestHeader("username") String username) throws JsonProcessingException {
        if(isAuthenticated(username)){
            MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("category","generalnews");
            queryParams.add("region","US");

            String url = "/news/list";
            return ResponseEntity.ok(httpBuilder.getJsonObject(httpBuilder.getFullUri(queryParams,allRequestParams,url).toUriString()).path("items").path("result"));
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    public boolean isAuthenticated(String username)
    {
        return userService.getUserByUserName(username).size()>0;
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }




}
