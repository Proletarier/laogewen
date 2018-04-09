package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.util.JDBCSQLite;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


/**
 * Created by wenheng on 2018/4/5.
 */

@Component
public class SpiderPicDao {

    public void insertPicture(List<Picture> pictureList) throws Exception {
        String sql = "INSERT  INTO lgw_pic(PIC_ID,NAME,TYPE_CODE,IMG,URL,MD5) " +
                "VALUES(NULL,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCSQLite.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            int i = 0;
            for (Picture picture : pictureList) {
                statement.setString(1, picture.getName());
                statement.setString(2, picture.getTypeCode());
                statement.setString(3, picture.getImg());
                statement.setString(4, picture.getUrl());
                statement.setString(5, picture.getMd5());
                statement.addBatch();
                i++;
                if (i % 2000 == 0) {
                    statement.executeBatch();
                }
            }
            statement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            JDBCSQLite.colseConnection(null, statement);
        }

    }


    public void updatePicture(Picture picture) throws Exception {
        String sql = "UPDATE lge_pic SET " +
                "NAME=?" +
                ",TYPE_CODE=?" +
                ",IMG=?" +
                "WHERE PIC_ID=?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCSQLite.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setString(1, picture.getName());
            statement.setString(2, picture.getTypeCode());
            statement.setString(3, picture.getImg());
            statement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw e;
        } finally {
            JDBCSQLite.colseConnection(null, statement);
        }

    }

    public Picture findById(Integer id) {
        String sql = "select * from lgw_pic where PIC_ID=?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Picture picture = null;
        try {
            connection = JDBCSQLite.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                picture = new Picture();
                picture.setPictureId(resultSet.getInt("pic_id"));
                picture.setName(resultSet.getString("name"));
                picture.setTypeCode(resultSet.getString("type_code"));
                picture.setImg(resultSet.getString("img"));
                picture.setUrl(resultSet.getString("url"));
                picture.setMd5(resultSet.getString("md5"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, statement);
        }

        return picture;
    }

    public List<Picture> searchPicture(PictureCondition condition) {
        String where = "";
        if (condition.getName() != null) {
            where += " and name like '%" + condition.getName() + "%'";
        }
        String sql = "select * from lgw_pic where 1=1 " + where + " order by rowid limit ?,?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Picture> list = Lists.newArrayList();
        try {
            conn = JDBCSQLite.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, condition.getOffset());
            statement.setInt(2, condition.getPageSize());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Picture picture = new Picture();
                picture.setPictureId(resultSet.getInt("pic_id"));
                picture.setName(resultSet.getString("name"));
                picture.setTypeCode(resultSet.getString("type_code"));
                picture.setImg(resultSet.getString("img"));
                picture.setUrl(resultSet.getString("url"));
                picture.setMd5(resultSet.getString("md5"));
                list.add(picture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, statement);
        }
        return list;

    }


    public int  findByCount(PictureCondition condition){
        String where = "";
        if (condition.getName() != null) {
            where += " and name like '%" + condition.getName() + "%'";
        }
        String sql = "select * from lgw_pic where 1=1 " + where;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count=0;
        try {
            conn = JDBCSQLite.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, condition.getOffset());
            statement.setInt(2, condition.getPageSize());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count=resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, statement);
        }
        return count;
    }


    public  void deletePicAll() throws  Exception{
        String  deletePic="delete from lgw_pic";
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            conn=JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            statement=conn.prepareStatement(deletePic);
            statement.executeUpdate();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.rollback();
            JDBCSQLite.colseConnection(null,statement);
        }
    }

}
