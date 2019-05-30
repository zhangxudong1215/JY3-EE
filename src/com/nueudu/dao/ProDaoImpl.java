package com.nueudu.dao;

import com.nueudu.pojo.Product;

import com.nueudu.pool.DruidSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProDaoImpl implements ProDao{
    private DruidSource dds;
    private QueryRunner qr;
    public ProDaoImpl(){
        this.dds=DruidSource.getSource();
        qr=new QueryRunner();
    }

    @Override
    public void addOneProduct(Product product) {
        Connection connection = dds.getConnection();
        String sql="insert into product values(?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(connection,sql,product.getPro_id(),product.getPro_name(),product.getPro_price(),product.getPro_image(),product.getPro_des(),product.getPro_stock(),product.getPro_date(),product.getPro_cate_id(),product.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public List<Product> getAllProduct(){
        Connection connection=dds.getConnection();
        String sql="select * from product";
        List<Product> products=null;
        try {
            products = qr.query(connection, sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection=dds.getConnection();
        String sql="UPDATE product SET pro_name=?,pro_price=?,pro_image=?,pro_des=?,pro_stock=?,pro_date=?,pro_cate_id=?, pro_factory=? WHERE  pro_id=?";
        try {
            qr.update(connection,sql,product.getPro_name(),product.getPro_price(),product.getPro_image(),product.getPro_des(),product.getPro_stock(),product.getPro_date(),product.getPro_cate_id(),product.getPro_factory(),product.getPro_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

