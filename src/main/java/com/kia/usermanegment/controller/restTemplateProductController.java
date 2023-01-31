package com.kia.usermanegment.controller;

import com.kia.usermanegment.model.Product;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class restTemplateProductController {

    RestTemplate restTemplate;

    public restTemplateProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/template/product",method = RequestMethod.GET)
    public String getProduct(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String > httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/products",HttpMethod.GET,httpEntity,String.class).getBody();
    }


    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String postProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
        return restTemplate.exchange("http://localhost:8081/products", HttpMethod.POST, httpEntity, String.class).getBody();
    }


    @RequestMapping(value = "/template/product/{id}", method = RequestMethod.PUT)
    public String updateProducts(@PathVariable("id") int id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<>(product, headers);
        return restTemplate.exchange("http://localhost:8081/products/" + id, HttpMethod.PUT, httpEntity, String.class).getBody();
    }


    @RequestMapping(value = "template/product/{id}",method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/products/"+id,HttpMethod.DELETE,httpEntity,String.class).getBody();
    }
}
