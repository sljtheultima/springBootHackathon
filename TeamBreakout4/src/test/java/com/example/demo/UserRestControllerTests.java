package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mvc;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void testGetAllUsers(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/AllUsers", HttpMethod.GET,null,
          new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(3, responseBody.size ()); // expected 3
    }

   @Test
    public void testGetUserByUserName(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/getUserByUserName/wongxx", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(1, responseBody.size ()); // expected 1
    }

    @Test
    public void testGetUserByFullName(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/getUserByUserName/Wong Xin Xian", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(1, responseBody.size ()); // expected 1
    }

/*    @Test
    public void testInsertUser(){

        String uri = "/insertNewUser";
        User user = new User("mel","ginger123","Melissa Ho");

        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }*/


    @Test
    public void deleteUser()  {
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/deleteUserByUserName/wongxx", HttpMethod.DELETE,null,Void.class);
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());

                }





}


