package com.abhi.sms.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/studentdb",
                "abhi",
                "4048");
        }
        catch(Exception e){
            e.printStackTrace();
        return null;

        }
    }

}
