package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<JsonNode> getEarningsData(@RequestParam("username") String username
            ,@RequestParam( value = "size",defaultValue = "10") int size
            ,@RequestParam(value = "region",defaultValue = "US") String region) throws JsonProcessingException {


        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/get-earnings?startDate=1585155600000&endDate=1589475600000";


        UriComponentsBuilder builder  = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("size",size)
                .queryParam("region",region);


        return ResponseEntity.ok(getJsonObject(builder.toUriString()));

    }

    @GetMapping("/historicalData")
   public ResponseEntity<JsonNode> getHistoricalData(@RequestParam("username") String username ,
                                                                 @RequestParam(value = "period1", defaultValue ="154648400") Long period1,
                                                                 @RequestParam(value = "period2",defaultValue = "1562086800") Long period2,
                                                                 @RequestParam(value = "symbol",defaultValue = "AMRN")String symbol,
                                                                 @RequestParam(value = "frequency",defaultValue = "1d",required = false)String freq,
                                                                 @RequestParam(value = "filter",defaultValue = "history",required = false) String filter) throws JsonProcessingException {


        String url = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v2/get-historical-data";
        UriComponentsBuilder builder  = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("period1",period1)
                .queryParam("period2",period2)
                .queryParam("symbol",symbol)
                .queryParam("frequency",freq)
                .queryParam("filter",filter);


        return ResponseEntity.ok(getJsonObject(builder.toUriString()));


    }
    
    public HttpEntity httpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(apiProperties.getHost_name(),apiProperties.getHost_value());
        headers.add(apiProperties.getKey_name(),apiProperties.getKey_value());
        return new HttpEntity(headers);
        
    }

    public JsonNode getJsonObject(String urlStr) throws JsonProcessingException {
        return new ObjectMapper().readTree(template.exchange(urlStr, HttpMethod.GET,httpHeader(),String.class).getBody().toString());
    }



}
