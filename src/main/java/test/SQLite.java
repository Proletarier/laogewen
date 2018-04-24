package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by wenheng on 2018/4/3.
 */
public class SQLite {

    public  static void  main(String[] args){

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
        createTable("select * from lgw_film");

    }

    public  static  void createTable(String sql){
        Connection conn=null;
        Statement  stmt=null;
        try{
            Class.forName("org.sqlite.JDBC");
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
