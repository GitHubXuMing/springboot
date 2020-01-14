package com.oasis.springboot.dao;

import com.oasis.springboot.dao.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class ProductDaoTest {
    @Autowired
    ProductDao productDao;
    @Test
    public void testFindById(){
       Product product = productDao.findById(1).get();
       System.out.println(product);
    }
}