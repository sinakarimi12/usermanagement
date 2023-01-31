package com.kia.usermanegment.service;

import com.kia.usermanegment.model.Product;

import java.util.Collection;
import java.util.stream.Collectors;

public interface ProductService {

    public abstract void createProduct(Product product);
    public abstract void updateProduct(Integer id,Product product);
    public abstract void deleteProduct(Integer id);
    public abstract Collection<Product> getProducts();
}
