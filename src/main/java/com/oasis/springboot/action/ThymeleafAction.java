package com.oasis.springboot.action;

import com.oasis.springboot.dao.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafAction {
    @RequestMapping("login.do")
    public String login(String username, String password, Map<String,Object> map){
        //字符串参数
        map.put("username",username);
        map.put("password",password);
        //字符串集合
        List<String> names = Arrays.asList("zhao","qian","sun","li");
        map.put("names",names);
        //对象集合
        List<Emp> emps = Arrays.asList(new Emp(1001,"ZHAO"),new Emp(1002,"QIAN"));
        map.put("emps",emps);
        return "first";
    }
}
