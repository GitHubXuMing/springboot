package com.oasis.springboot.dao.pojo;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MyDataSource {
    private String driver;

    @Max(value = 70,message="too large")
    @Min(value = 18,message = "too little")
    private int port;

    private String username;
    private String password;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MyDataSource(String driver, int port, String username, String password) {
        this.driver = driver;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public MyDataSource() {
    }
}
