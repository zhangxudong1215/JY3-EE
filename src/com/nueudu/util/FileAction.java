package com.nueudu.util;

import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;
/**
工具类
 */
public class FileAction {
    public static String uploadFile(Part part){

        String submittedFileName=part.getSubmittedFileName();
        InputStream inputStream = null;

        
        //创建uuid
        UUID uuid = UUID.randomUUID();
        OutputStream os= null;
        String name=uuid+submittedFileName;
        try {
            inputStream = part.getInputStream();
            os = new FileOutputStream("E:\\img\\"+name);
            int buffer=0;
            byte [] bs=new byte[1024];
            while ((buffer=inputStream.read(bs))!=-1){

                os.write(bs,0,buffer);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return name;
    }

    }

