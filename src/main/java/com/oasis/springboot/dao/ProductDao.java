package com.oasis.springboot.dao;

import com.oasis.springboot.dao.pojo.Product;

import java.util.List;

public interface ProductDao{
    public List<Product> findAll();
}
