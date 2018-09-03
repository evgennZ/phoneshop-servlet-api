package com.es.phoneshop.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.es.phoneshop.model.ArrayListProductDAO.generateId;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayListProductDAOTest {
    private ProductDAO products;

    @Before
    public void setUp() throws Exception {

        products = ArrayListProductDAO.getInstance();
        products.removeAll();

        products.save(new Product( "code 1", "description 1", new BigDecimal(100),
                Currency.getInstance(Locale.UK), 100));
        products.save(new Product( "code 2", "description 2", new BigDecimal(200),
                Currency.getInstance(Locale.UK), 200));
        products.save(new Product( "code 3", "description 3", new BigDecimal(300),
                Currency.getInstance(Locale.UK), 300));
        products.save(new Product("code 4", "description 4", new BigDecimal(400),
                Currency.getInstance(Locale.UK), 0));
        products.save(new Product( "code 5", "description 5", null,
                Currency.getInstance(Locale.UK), 500));
    }

    @Test
    public void getInstance() {
        Assert.assertNotNull(ArrayListProductDAO.getInstance());
        Assert.assertTrue(ArrayListProductDAO.getInstance()==ArrayListProductDAO.getInstance());
    }

    @Test
    public void getProduct() {
        Assert.assertTrue(products.getProduct(1l).isPresent());
        if(products.getProduct(1l).isPresent()) {
            assertThat(products.getProduct(1l).get().getCode(), is("code 1"));
        }
    }

    @Test
    public void findProducts() {
        final List<Product> products = this.products.findProducts();
        Assert.assertNotNull(products);
    }

    @Test
    public void save() {
        Optional<Product> product = products.getProduct(6l);
        Assert.assertFalse(product.isPresent());

        products.save(new Product("code 6", "description 5", null,
                Currency.getInstance(Locale.UK), 500));

        Optional<Product> product6 = products.getProduct(6l);

        Assert.assertTrue(product6.isPresent());
        Assert.assertTrue(product6.get().getDescription().equals("description 5"));
    }

    @Test
    public void delete() {
        Optional<Product> product = products.getProduct(5l);
        Assert.assertTrue(product.isPresent());

        products.delete(5l);

        Optional<Product> product5 = products.getProduct(5l);
        Assert.assertFalse(product5.isPresent());
    }
}