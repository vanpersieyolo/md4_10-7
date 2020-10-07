package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static List<Product> products;
    static {
        products = new ArrayList();
        products.add(new Product(1,"bánh",10000));
        products.add(new Product(2,"kẹo",10000));
        products.add(new Product(3,"sữa",10000));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = this.products;
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product: products) {
            if (product.getProductId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getProductId() == product.getProductId()){
                product1.setProductName(product.getProductName());
                product1.setProductPrice(product.getProductPrice());
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product product: products) {
            if (product.getProductId() == id){
                products.remove(product);
                return;
            }
        }
    }
}
