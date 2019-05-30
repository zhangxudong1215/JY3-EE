package com.nueudu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("load");
        Part file1= request.getPart("file1");
        String submittedFileName=file1.getSubmittedFileName();
        InputStream inputStream = file1.getInputStream();
        //创建uuid
        UUID uuid = UUID.randomUUID();
        OutputStream os= new FileOutputStream("E:\\img\\"+uuid+submittedFileName);
        int buffer=0;
        byte [] bs=new byte[1024];
        while ((buffer=inputStream.read(bs))!=-1){

            os.write(bs,0,buffer);

        }
        os.close();
        inputStream.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
    }
}
