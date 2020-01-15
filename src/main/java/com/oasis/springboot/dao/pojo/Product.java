package com.oasis.springboot.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private int pid;
    private String pname;
    private BigDecimal price;
    private Date pdate;

    public Product(String pname, BigDecimal price, Date pdate) {
        this.pname = pname;
        this.price = price;
        this.pdate = pdate;
    }
}
