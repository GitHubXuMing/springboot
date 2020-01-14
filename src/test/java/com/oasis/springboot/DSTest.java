package com.oasis.springboot;

import com.oasis.springboot.dao.pojo.MyDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DSTest {
    @Autowired
    MyDataSource dataSource;
    @Test
    public void test1(){
        dataSource.setDriver("mysql");
        dataSource.setUsername("root");
        System.out.println("***************"+dataSource);
    }
}
