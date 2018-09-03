package com.es.phoneshop.model;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.*;

public class CartServiceTest {
    private CartService cartService;
    private Cart cart;
    private Product product;

    @Before
    public void setUp() throws Exception {
        cartService = CartService.getInstance();
        cart = new Cart();
        product = new Product( "code 1", "description 1", new BigDecimal(100),
                Currency.getInstance(Locale.UK), 100);
    }

    @AfterAll
    public void clear(){
        cart.getCartItems().clear();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(cartService);
    }

    @Test
    public void testAdd() {
        cartService.add(cart, product, 10);
        assertFalse(cart.getCartItems().isEmpty());
    }
}