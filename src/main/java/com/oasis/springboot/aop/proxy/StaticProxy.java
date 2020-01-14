package com.oasis.springboot.aop.proxy;

interface UserDao{
    public void find();
    public void save();
}

class UserDaoImpl implements UserDao{

    @Override
    public void find() {
        System.out.println("test find");
    }

    @Override
    public void save() {
        System.out.println("test save");
    }
}
//编译时，就生成了class字节码文件
class UserDaoProxy implements UserDao{

    private UserDao instance = new UserDaoImpl();

    @Override
    public void find() {
        instance.find();
    }

    @Override
    public void save() {
        System.out.println("begin transaction");
        instance.save();
        System.out.println("commit transaction");
    }
}


public class StaticProxy {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoProxy();
        userDao.find();
        userDao.save();
    }
}
