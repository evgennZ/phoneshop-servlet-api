package com.es.phoneshop.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static com.es.phoneshop.model.ArrayListProductDAO.generateId;
import static org.junit.Assert.*;

public class ArrayListProductDAOTest {
    ProductDAO products;

    @Before
    public void setUp() throws Exception {

        products = ArrayListProductDAO.getInstance();

        products.save(new Product(ArrayListProductDAO.generateId(), "code 1", "description 1", new BigDecimal(100),
                Currency.getInstance(Locale.UK), 100));
        products.save(new Product(ArrayListProductDAO.generateId(), "code 2", "description 2", new BigDecimal(200),
                Currency.getInstance(Locale.UK), 200));
        products.save(new Product(ArrayListProductDAO.generateId(), "code 3", "description 3", new BigDecimal(300),
                Currency.getInstance(Locale.UK), 300));
        products.save(new Product(ArrayListProductDAO.generateId(), "code 4", "description 4", new BigDecimal(400),
                Currency.getInstance(Locale.UK), 0));
        products.save(new Product(ArrayListProductDAO.generateId(), "code 5", "description 5", null,
                Currency.getInstance(Locale.UK), 500));

    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(ArrayListProductDAO.getInstance());
    }

    @Test
    public void getProduct() {
        Assert.assertEquals("code 1",products.getProduct(1l).getCode());
    }

    @Test
    public void findProducts() {
        Assert.assertNotNull(products.findProducts());
    }

    @Test
    public void save() {
        Assert.assertNull(products.getProduct(6l));
        products.save(new Product(ArrayListProductDAO.generateId(), "code 6", "description 5", null,
                Currency.getInstance(Locale.UK), 500));
        Assert.assertNotNull(products.getProduct(6l));
    }

    @Test
    public void delete() {
        Assert.assertNotNull(products.getProduct(5l));
        products.delete(5L);
        Assert.assertNull(products.getProduct(5l));
    }

}