package cinemasystem.dao;
//Java DataBase Connectivity

public interface JdbcConfig{
    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/csdao";
    String USERNAME = "root";
    String PASSWORD = "123456";
}