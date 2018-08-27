package com.es.phoneshop.model;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Optional<Product> getProduct(Long id);
    List<Product> findProducts();
    void save(Product product);
    void delete(Long id);
    void removeAll();
}