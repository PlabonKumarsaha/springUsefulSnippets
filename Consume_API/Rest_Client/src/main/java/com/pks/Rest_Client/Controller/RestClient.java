package com.pks.Rest_Client.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pks.Rest_Client.Model.User;
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




    }
