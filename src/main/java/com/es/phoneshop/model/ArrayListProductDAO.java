package com.es.phoneshop.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListProductDAO implements ProductDAO {
    private volatile List<Product> products;
    private static ArrayListProductDAO instance = null;

    private static Long counter = 1L;

    public static synchronized Long generateId(){
        return counter++;
    }

    public static ArrayListProductDAO getInstance(){
        if (instance == null){
            synchronized (ArrayListProductDAO.class){
                if (instance == null)
                    instance = new ArrayListProductDAO();
            }
        }
        return instance;
    }

    private ArrayListProductDAO() {
        products = new ArrayList<>();
    }

    public Optional<Product> getProduct(Long id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                return Optional.ofNullable(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> findProducts() {
        List<Product> productList = products.stream()
                .filter(a -> a.getPrice() != null && (a.getStock()!=null && a.getStock() > 0 ))
                .collect(Collectors.toList());
        return productList;
    }

    public void save(Product product) {
        List<Product> productList = products.stream()
                .filter(a -> (a.getCode().equals(product.getCode()) ) )
                .collect(Collectors.toList());
        if(productList.isEmpty()){
            product.setId(generateId());
            products.add(product);
        }
    }

    public void removeAll(){
        counter = 1L;
        while (!products.isEmpty())products.remove(0);
    }

    @Override
    public void delete(Long id) {
        remove(id);
    }

    public void remove(Long id) {
        if(getProduct(id).isPresent()) products.remove(getProduct(id).get());

    }
}