package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class HttpBuilder {


        @Autowired
        ApiProperties apiProperties;

        RestTemplate template = new RestTemplate();

        public UriComponentsBuilder getFullUri(MultiValueMap<String, String> defaultvalues, Map<String,String> actualParams, String url){
            getParamsValues(defaultvalues,actualParams);
            return UriComponentsBuilder.fromHttpUrl(url).queryParams(defaultvalues);

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

        public void getParamsValues(MultiValueMap<String, String> defaultvalues, Map<String,String> actualParams){
            actualParams.forEach((k,v) ->{
                defaultvalues.add(k,defaultvalues.getFirst(k));
            });



    }
}
