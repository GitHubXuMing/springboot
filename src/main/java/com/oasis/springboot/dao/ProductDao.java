package com.oasis.springboot.dao;

import com.oasis.springboot.dao.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
