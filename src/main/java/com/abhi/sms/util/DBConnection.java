package com.abhi.sms.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL =
        "jdbc:postgresql://localhost:5432/studentdb";

    private static final String USER = "abhi";

    private static final String PASSWORD = "4048";
    public static Connection getConnection(){
        
        try{
            return DriverManager.getConnection(
                                         URL,
                                         USER,
                                         PASSWORD);
        }
        catch(Exception e){
            e.printStackTrace();
        return null;

        }
    }

}
