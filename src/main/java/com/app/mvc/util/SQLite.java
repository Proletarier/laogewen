package com.app.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wenheng on 2018/4/3.
 */
public class SQLite {

   static   Connection conn=null;

    static {
        try{
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection("jdbc:sqlite:laogewen.db");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
