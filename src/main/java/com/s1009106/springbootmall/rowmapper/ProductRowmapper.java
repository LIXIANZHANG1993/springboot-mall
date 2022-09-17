package com.s1009106.springbootmall.rowmapper;

import com.s1009106.springbootmall.constant.ProductCategory;
import com.s1009106.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowmapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        // 先用一個String變數，把資料庫的值取出來
        String categoryStr = resultSet.getString("category");
        // 再用 enum 的 valueOf 方法，把 enum 裡面定義的資料取出來
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);

        //也可以寫成下面這樣
        //product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));

        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));


        return product;
    }
}
