package com.app.mvc.util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.sql.*;

/**
 * Created by wenheng on 2018/4/3.
 */
public class JDBCSQLite {

    static Connection conn = null;

     private static String initializeTable="create table lgw_film \n" +
             "(\n" +
             "  FILM_ID   \tINT PRIMARY KEY   NOT NULL,\n" +
             "  FILM_NAME \tVARCHAR(200)      NOT NULL,\n" +
             "  FILM_TYPE     VARCHAR(20)       NOT NULL,\n" +
             "  TITLE_IMG     VARCHAR(100)      NOT NULL,\n" +
             "  CONTENT_IMG   VARCHAR(255),\n" +
             "  HTTP          VARCHAR(200),\n" +
             "  XFPLAY        VARCHAR(200),\n" +
             "  ED2K          VARCHAR(200),\n" +
             "  THUNDER       VARCHAR(200),\n" +
             "  QQDL          VARCHAR(200),\n" +
             "  FLASHGET      VARCHAR(200),\n" +
             "  URL \t\t\tVARCHAR(50)\t\t  NOT NULL,\n" +
             "  MD5 \t\t\tVARCHAR(50)       NOT NULL\n" +
             ");\n" +
             "\n" +
             "create table  lgw_pic\n" +
             "(\n" +
             " PIC_ID    INT     PRIMARY KEY   NOT NULL,\n" +
             " NAME      VARCHAR(100)          NOT NULL,\n" +
             " TYPE_CODE VARCHAR(100)          NOT NULL,\n" +
             " IMG       VARCHAR(500)          NOT NULL,\n" +
             " URL       VARCHAR(100)          NOT NULL,\n" +
             " MD5       VARCHAR(100)          NOT NULL\n" +
             ");\n" +
             "\n" +
             "create table lgw_novel\n" +
             "(\n" +
             "  NOVEL_ID   INT PRIMARY KEY  NOT NULL,\n" +
             "  TYPE_CODE  VARCHAR(50)      NOT NULL,\n" +
             "  TITLE      VARCHAR(100),\n" +
             "  URL        VARCHAR(100)     NOT NULL,\n" +
             "  MD5        VARCHAR(100)     NOT NULL\n" +
             ");\n" +
             "\n" +
             "create table lgw_novel_page\n" +
             "(\n" +
             "  NOVEL_PAGE_ID  INT PRIMARY KEY  NOT NULL,\n" +
             "  NOVEL_ID       INT  NOT NULL,\n" +
             "  PAGE           INT  NOT NULL,\n" +
             "  CONTENT        TEXT NOT NULL\n" +
             ");";



    static {
        try  {
            Class.forName("org.sqlite.JDBC");
            initializeDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void  initializeDataBase(){
        String  sql="select count(1) from  sqlite_master";
        int count=0;
        try(Connection connection=getConnection();
            Statement stmt=connection.createStatement()){
            ResultSet resultSet=stmt.executeQuery(sql);
            if(resultSet.next()){
                count=resultSet.getInt(1);
            }
        }catch (Exception e){
                e.printStackTrace();
        }

        if(count==0){
            createTable(initializeTable);
        }

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
        String[] batchSql=sql.split(";");
        try{
            conn= getConnection();
            stmt=conn.createStatement();
            for(int i=0;i<batchSql.length;i++){
                stmt.addBatch(batchSql[i]);
            }
            stmt.executeBatch();
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
