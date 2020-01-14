package com.oasis.springboot.action;

import com.oasis.springboot.dao.pojo.MyDataSource;
import com.oasis.springboot.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OasisAction {

    @RequestMapping(value = "hello.do",method = RequestMethod.GET)
    public User hello(
            @RequestParam(value = "uname",required = true) String username,
            @RequestParam(value = "pwd",required = false,defaultValue = "123456") String password)
    throws Exception{
        User user = new User(username,password);
        return user;
    }
    @GetMapping("ds.do")
    public String testValid(@Valid MyDataSource dataSource, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String code = bindingResult.getFieldError().getCode();
            String errMsg = bindingResult.getFieldError().getDefaultMessage();
            return code+":"+errMsg;
        }
        return dataSource.toString();
    }
}
