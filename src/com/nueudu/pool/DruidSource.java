package com.nueudu.pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidSource {

    private  static Properties prop=new Properties();
    private  static DruidSource ds=null;

    private  DruidSource(){}

    public  static DruidSource getSource(){
        if(null==ds){
           ds=new DruidSource();
        }
        return  ds;
    }
     public Connection getConnection(){
         try {
             InputStream stream = DruidSource.class.getResourceAsStream("/mysql.properties");
             System.out.println(stream);
             prop.load(stream);
            DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);
            Connection connection=dataSource.getConnection();
            return connection;
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();
         }
            return  null;
     }

     public  static void main(String[] args){
      DruidSource datasource=DruidSource.getSource();
      Connection connection= datasource.getConnection();
      System.out.println(connection);
     }

}
