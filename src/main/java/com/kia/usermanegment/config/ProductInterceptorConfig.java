package com.kia.usermanegment.config;

import com.kia.usermanegment.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProductInterceptorConfig implements WebMvcConfigurer {


    ProductInterceptor productInterceptor;

    public ProductInterceptorConfig(ProductInterceptor productInterceptor) {
        this.productInterceptor = productInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productInterceptor);
    }
}
