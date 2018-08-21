package com.es.phoneshop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ArrayListProductDao implements ProductDao {
    private ArrayList<Product> productsArray = new ArrayList<Product>();

    public ArrayListProductDao() {
        for (int i=0;i<=10; i++){
            productsArray.add(new Product((long)i,"Code of product "+i,"product decription of "+i,new BigDecimal(1.0),12*i));
        }
    }

    public Product getProduct(Long id) {
        for(int i=0;i<productsArray.size();i++) if(productsArray.get(i).getId()==id) return productsArray.get(i);
        return null;
    }

    public List<Product> findProducts() {
        return productsArray;
    }

    public void save(Product product) {
        productsArray.add(product);
    }

    public void delete(Long id) {
        for(int i=0;i<productsArray.size();i++) if(productsArray.get(i).getId()==id) productsArray.remove(i);
    }
}
