package com.oasis.springboot.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class ProductDaoTest {
    @Autowired
    ProductDao productDao;

    @Test
    void findAll() {
        productDao.findAll().forEach(System.out::println);
    }
}