package com.app.mvc.util;

import java.sql.*;

/**
 * Created by wenheng on 2018/4/3.
 */
public class JDBCSQLite {

    static Connection conn = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            initSqlite();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  static void   initSqlite(){
        String filmSQL="create table  lgw_film" +
                "(FILM_ID,FILM_NAME,FILM_TYPE,TITLE_IMG,CONTENT_IGM,HTTP,XFPLAY,ED2K,THUNDER,QQDL," +
                "FLASHGET,URL,MD5);";

        String picSQL="create table lgw_pic" +
                "(PIC_ID,NAME,TYPE_CODE,IMG,URL,MD5);";

        String novelSQL="create table lge_novel " +
                "(NOVEL_ID,TYPE_CODE,TITLE,URL,MD5);";

        String novelPageSQL="create table lge_novel_page" +
                "(NOVEL_PAGE_ID,NOVEL_ID,PAGE,CONTENT);";

        createTable(filmSQL);
        createTable(picSQL);
        createTable(novelSQL);
    }


    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection("jdbc:sqlite:laogewen.db");
        }

        return conn;
    }

    public static void colseConnection(ResultSet resultSet, PreparedStatement statement) {

        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public  static  void createTable(String sql){

        Connection conn=null;
        Statement  stmt=null;
        try{
            conn= DriverManager.getConnection("jdbc:sqlite:laogewen.db");
            stmt=conn.createStatement();
            stmt.executeQuery(sql);
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
