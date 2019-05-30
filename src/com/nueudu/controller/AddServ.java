package com.nueudu.controller;

import com.nueudu.dao.ProDao;
import com.nueudu.dao.ProDaoImpl;
import com.nueudu.pojo.Product;
import com.nueudu.util.FileAction;
import com.nueudu.util.ProUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddServ",urlPatterns = "/add.do")
@MultipartConfig
public class AddServ extends HttpServlet {
    private ProDao pd;
    @Override
    public void init() throws ServletException {
    pd=new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proName = request.getParameter("proName");
        String proPrice = request.getParameter("proPrice");
        Part file1 = request.getPart("file1");
        String realFileName = FileAction.uploadFile(file1);

        String proDes = request.getParameter("proDes");
        String proStock = request.getParameter("proStock");
        String proDate = request.getParameter("proDate");
        String proCateId = request.getParameter("proCateId");
        String proFac = request.getParameter("proFac");
        System.out.println(proPrice);
        System.out.println(Double.parseDouble(proPrice));


        Product product = new Product(ProUtil.getProId(),proName,Double.parseDouble(proPrice),realFileName,proDes,Short.parseShort(proStock),ProUtil.getStringDate(proDate),Short.valueOf(proCateId),proFac);

        pd.addOneProduct(product);
        response.sendRedirect("page.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
