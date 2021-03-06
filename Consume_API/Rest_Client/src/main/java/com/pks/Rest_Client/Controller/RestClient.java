package com.pks.Rest_Client.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pks.Rest_Client.Model.User;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestClient {
    private static final String GETALL_API_URL = "http://localhost:8080/api/users/";
    private static final String CREATE_API_URL = "http://localhost:8080/api/users/";
    private static final String GET_BY_ID_API_URL = "http://localhost:8080/api/users/{id}";
    private static final String UPDATE_API_URL = "http://localhost:8080/api/users/{id}";
    private static final String DELETE_API_URL = "http://localhost:8080/api/users/{id}";

    RestTemplate restTemplate = new RestTemplate();
    public void callGetAllUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String>entity = new HttpEntity<>("parameters",headers);
        String  response= restTemplate.exchange(GETALL_API_URL,
                HttpMethod.GET,entity,String.class).getBody();
        System.out.println("response : " +response);

        Gson gson = new GsonBuilder().create();
        List<User> users =gson.fromJson(response,  List.class);
        System.out.println("0 th from list : "+ users.get(0));
        ResponseEntity<String>res =restTemplate.exchange(GETALL_API_URL,HttpMethod.GET,entity,String.class);

        System.out.println(" string user "+ res);
    }
    public void callUserByIdUserId(long id) {
        Map<String,Long>param = new HashMap<>();
        param.put("id",id);
        User user = restTemplate.getForObject(GET_BY_ID_API_URL,User.class,param);
        System.out.println(user.toString());
        System.out.println("User email :"+user.getEmail());
    }

    public void callCreateUser(User user) {
        ResponseEntity<User>userResponse = restTemplate.postForEntity(CREATE_API_URL,user,User.class);
        System.out.println(userResponse);
        System.out.println("Only body from create response : "+userResponse.getBody());
        System.out.println("Only email from create response : "+userResponse.getBody().getEmail());
    }

    public void callUpdateUser(User user,long id) {
        Map<String,Long>param = new HashMap<>();
        param.put("id",id);
        User updated = new User();
        updated.setEmail(user.getEmail());
        updated.setFirstName(user.getFirstName());
        updated.setLastName(user.getLastName());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(updated, headers);
        ResponseEntity<User>userResponse= restTemplate.exchange(UPDATE_API_URL,HttpMethod.PUT,requestEntity,User.class,param);
        System.out.println(userResponse.getBody());
    }
    public void callDeleteUser(long id) {
        Map<String,Long>param = new HashMap<>();
        param.put("id",id);
        restTemplate.delete(DELETE_API_URL,param);
    }

    }
