package com.nueudu.controller;

import com.nueudu.dao.ProDao;
import com.nueudu.dao.ProDaoImpl;
import com.nueudu.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChaServlet",urlPatterns = "/cha.do")
public class ChaServlet extends HttpServlet {

    private ProDao ud;

    @Override
    public void init() throws ServletException {
       ud=new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Product> allproduct=ud.getAllProduct();
        request.setAttribute("products",allproduct );
        request.getRequestDispatcher("page.jsp").forward(request,response);


    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
