package com.nueudu.dao;

import com.nueudu.pojo.Product;

import java.util.List;

public interface ProDao {
    void addOneProduct(Product product);
    List<Product> getAllProduct();
    void updateProduct(Product product);

}
