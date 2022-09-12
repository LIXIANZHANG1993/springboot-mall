package com.s1009106.springbootmall.service.impl;

import com.s1009106.springbootmall.dao.ProductDao;
import com.s1009106.springbootmall.model.Product;
import com.s1009106.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
