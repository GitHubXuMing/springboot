package com.oasis.springboot.action;

import com.oasis.springboot.common.ResultRes;
import com.oasis.springboot.dao.pojo.Product;
import com.oasis.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAction {
    @Autowired
    ProductService productService;
    @GetMapping("product/{id}")
    public ResultRes<Product> findById(@PathVariable("id") Integer id) throws Exception {
        //注意，
        return productService.findById(id);
    }
}
