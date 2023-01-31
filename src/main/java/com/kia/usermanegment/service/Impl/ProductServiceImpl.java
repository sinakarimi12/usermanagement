package com.kia.usermanegment.service.Impl;

import com.kia.usermanegment.exception.ProductNotFoundException;
import com.kia.usermanegment.model.Product;
import com.kia.usermanegment.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productRepo = new HashMap<>();

    static {
        Product benz = new Product();
        benz.setId(1);
        benz.setName("Volvo");
        benz.setPrice(200000L);
        benz.setColor("Golden");
        productRepo.put(benz.getId(), benz);

        Product bmw = new Product();
        bmw.setId(2);
        bmw.setName("i8");
        bmw.setPrice(100000L);
        bmw.setColor("Black");
        productRepo.put(bmw.getId(), bmw);
    }

    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct( Integer id,Product product) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id,product);    }

    @Override
    public void deleteProduct(Integer id) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }
}
