package com.nueudu.controller;

import com.nueudu.dao.UserDao;
import com.nueudu.dao.UserDaoImpl;
import com.nueudu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateServlet",urlPatterns = "/update.do")
public class updateServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud=new UserDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id=request.getParameter("id");
     String username=request.getParameter("username");
     String psw=request.getParameter("psw");
        User user1 = new User(Integer.parseInt(id), username, psw);
        ud.updateUser(user1);
        response.sendRedirect("user.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
