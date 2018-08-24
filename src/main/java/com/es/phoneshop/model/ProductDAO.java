package com.es.phoneshop.model;

import java.util.List;

public interface ProductDAO {
    Product getProduct(Long id);
    List<Product> findProducts();
    void save(Product product);
    void delete(Long id);
}