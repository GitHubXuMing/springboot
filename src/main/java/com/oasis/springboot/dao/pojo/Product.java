package com.oasis.springboot.dao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "product")//设置ORM映射的表名，Product类默认对应的表名就是product
@Entity  //表示该POJO类ROM映射到表
public class Product implements Serializable {
    @Id
    @GeneratedValue  //设置自增主键
    private int pid;
    @Column(length = 20, unique = true, nullable = false) //设置字段长度，唯一约束，非空约束
    private String pname;
    private BigDecimal price;
    private Date pdate;

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Product(int pid, String pname, BigDecimal price, Date pdate) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pdate = pdate;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pdate=" + pdate +
                '}';
    }
}
