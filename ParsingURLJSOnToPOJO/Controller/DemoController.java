package com.demo.practice.Controller;

import com.demo.practice.Model.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class DemoController {

    RestTemplate restTemplate = new RestTemplate();

    //converting the json as string
    @RequestMapping("/convert")
    public String sayHello() {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=e035ca5c00b6f72b3e2447c49dd92c57";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

// parsing the data as POJO using GSON
    @RequestMapping("/url")
    public String convertURL() {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=e035ca5c00b6f72b3e2447c49dd92c57";

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity <String> entity = new HttpEntity<String>(headers);
            Gson gson = new GsonBuilder().create();
            String st =  restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
            Root root =gson.fromJson(st, Root.class);
            System.out.println("coord");
            System.out.println(root.getCoord().getLat());
            System.out.println(root.getCoord().getLon());

            System.out.println("weather");
            for(int i =0; i< root.getWeather().size();i++){
                System.out.println(root.getWeather().get(i).getId());
                System.out.println(root.getWeather().get(i).getIcon());
                System.out.println(root.getWeather().get(i).getDescription());
                System.out.println(root.getWeather().get(i).getMain());
            }

            System.out.println("base");
            System.out.println(root.getBase());

            System.out.println("main");
            System.out.println(root.getMain().getTemp_max());
            System.out.println(root.getMain().getTemp());
            System.out.println(root.getMain().getFeels_like());
            System.out.println(root.getMain().getHumidity());
            System.out.println(root.getMain().getPressure());

            System.out.println("dt");
            System.out.println(root.getDt());

        return "working!!!";
    }


}
