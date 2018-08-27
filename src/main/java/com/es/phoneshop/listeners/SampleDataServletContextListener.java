package com.es.phoneshop.listeners;

import com.es.phoneshop.model.ArrayListProductDAO;
import com.es.phoneshop.model.Product;
import com.es.phoneshop.model.ProductDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static com.es.phoneshop.model.ArrayListProductDAO.generateId;

@WebListener
public class SampleDataServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        String enableAutowriteTestDataParam = servletContextEvent.getServletContext().getInitParameter("enableAutowriteTestData");
        if(!Boolean.parseBoolean(enableAutowriteTestDataParam)) return;

        ProductDAO products = ArrayListProductDAO.getInstance();

        products.save(new Product("code 1", "description 1", new BigDecimal(100),
                Currency.getInstance(Locale.UK), 100));
        products.save(new Product("code 2", "description 2", new BigDecimal(400),
                Currency.getInstance(Locale.UK), 1));
        products.save(new Product("code 3", "description 3", new BigDecimal(200),
                Currency.getInstance(Locale.UK), 200));
        products.save(new Product( "code 4", "description 4", new BigDecimal(300),
                Currency.getInstance(Locale.UK), 300));
        products.save(new Product( "code 5", "description 5", new BigDecimal(400),
                Currency.getInstance(Locale.UK), 2));

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
