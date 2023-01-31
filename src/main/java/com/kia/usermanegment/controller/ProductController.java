package com.kia.usermanegment.controller;

import com.kia.usermanegment.exception.ProductNotFoundException;
import com.kia.usermanegment.model.Product;
import com.kia.usermanegment.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Value("source_management")
    private String appName;

    @GetMapping("/app")
    public String applicationName() {
        logger.info("in this here I got application name");
        logger.warn("application name should be true");
        return appName;
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }


    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id,@RequestBody Product product ){
        productService.updateProduct(id,product);
        return new ResponseEntity<>("product update successfully",HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted successfully",HttpStatus.OK);
    }

}
