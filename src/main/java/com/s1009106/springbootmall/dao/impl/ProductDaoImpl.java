package com.s1009106.springbootmall.dao.impl;

import com.s1009106.springbootmall.dao.ProductDao;
import com.s1009106.springbootmall.model.Product;
import com.s1009106.springbootmall.rowmapper.ProductRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemp;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "select product_id,product_name,category,image_url,price,stock,description,created_date,last_modified_date from product where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemp.query(sql, map, new ProductRowmapper());
        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }
}
