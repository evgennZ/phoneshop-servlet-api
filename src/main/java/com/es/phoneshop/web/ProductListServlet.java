package com.es.phoneshop.web;

import com.es.phoneshop.model.ArrayListProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductListServlet extends HttpServlet {
    private ArrayListProductDao arrayListProductDao;
    @Override
    public void init() throws ServletException {
        super.init();
        arrayListProductDao = new ArrayListProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", arrayListProductDao.findProducts());
        request.getRequestDispatcher("/WEB-INF/pages/productList.jsp").forward(request, response);
    }

}
