package com.example.demo;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    // Testing get all users
    @Test
    public void testGetAllUsers(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/AllUsers", HttpMethod.GET,null,
          new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(3, responseBody.size ()); // expected 3
    }

    // Testing get user by username
   @Test
    public void testGetUserByUserName(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/getUserByUserName/hal", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(1, responseBody.size ()); // expected 1
    }

    // Testing get user by fullname
    @Test
    public void testGetUserByFullName(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/getUserByFullName/Goh Chong Rui", HttpMethod.GET,null,
                new ParameterizedTypeReference<List<User>>(){});

        List<User>responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
        assertEquals(1, responseBody.size ()); // expected 1
    }


    // Testing insert new user
    @Test
    public void testInsertUser(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject userJsonObject = new JSONObject();
        userJsonObject.put("username","mel");
        userJsonObject.put("password","kehuh913'2");
        userJsonObject.put("fullname","Melissa Ho");

        HttpEntity<String> request =
                new HttpEntity<String>(userJsonObject.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("/insertNewUser", HttpMethod.POST,request,String.class);
        assertEquals(HttpStatus.CREATED , responseEntity.getStatusCode());
    }

    // Testing update current user by username
    @Test
    public void testUpdateUser(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject userJsonObject = new JSONObject();
        userJsonObject.put("username","xxwong");
        userJsonObject.put("password","u1h3b23r");
        userJsonObject.put("fullname","Xin Xian Wong");

        HttpEntity<String> request =
                new HttpEntity<String>(userJsonObject.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("/updateUserByUsername/wongxx", HttpMethod.PUT,request,String.class);
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
    }

    // Testing delete user by username
    @Test
    public void deleteUser()  {
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/deleteUserByUserName/wongxx", HttpMethod.DELETE,null,Void.class);
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());

                }

}


