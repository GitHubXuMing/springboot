package com.oasis.springboot.service;

import com.oasis.springboot.common.ResultRes;
import com.oasis.springboot.common.ex.ProductException;
import com.oasis.springboot.common.penum.ProductEnum;
import com.oasis.springboot.dao.ProductDao;
import com.oasis.springboot.dao.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    public ResultRes<Product> findById(Integer id) throws Exception{
        Product product = productDao.findById(id).get();
        if(product == null){
            throw new ProductException(ProductEnum.PROCUT_NOT_FOUND);
        }else if(product.getPrice().doubleValue() > 1000){
            throw new ProductException(ProductEnum.TOO_EXPENSIVE);
        }else if(product.getPrice().doubleValue()<10){
            throw new ProductException(ProductEnum.TOO_CHEAP);
        }
        //注意：与之前的项目不同，没有调用error方法返回错误信息，而是直接抛出异常
        return ResultRes.success(product);
    }
}
