package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.po.Film;
import com.app.mvc.util.JDBCSQLite;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by wenheng on 2018/4/4.
 */

@Component
public class SpiderFilmDao {


    public void insertFilm(List<Film> filmList) throws Exception {

        String sql = "insert into lgw_film(" +
                "FILM_ID,FILM_NAME,FILM_TYPE,TITLE_IMG,CONTENT_IGM,HTTP,XFPLAY,ED2K,THUNDER,QQDL,FLASHGET,URL,MD5) " +
                " VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            int i = 0;
            for (Film film : filmList) {
                ps.setString(1, film.getFilmName());
                ps.setString(2, film.getFilmType());
                ps.setString(3, film.getTitleImg());
                ps.setString(4, film.getContentImg());
                ps.setString(5, film.getHttp());
                ps.setString(6, film.getXfplay());
                ps.setString(7, film.getEd2k());
                ps.setString(8, film.getThunder());
                ps.setString(9, film.getQqdl());
                ps.setString(10, film.getFlashGet());
                ps.setString(11, film.getUrl());
                ps.setString(12, film.getMd5());
                ps.addBatch();
                i++;
                if (i % 2000 == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(null, ps);
        }
    }

    public void updateFilm(Film film) throws Exception {
        String update = "update lgw_film set" +
                " FILM_NAME=?" +
                ",FILM_TYPE=?" +
                ",TITLE_IMG=?" +
                ",CONTENT_IGM=?" +
                ",HTTP=?" +
                ",XFPLAY=?" +
                ",ED2K=?" +
                ",THUNDER=?" +
                ",QQDL=?" +
                ",FLASHGET=?" +
                "where FILM_ID=?";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(update);
            ps.setString(1, film.getFilmName());
            ps.setString(2, film.getFilmType());
            ps.setString(3, film.getTitleImg());
            ps.setString(4, film.getContentImg());
            ps.setString(5, film.getHttp());
            ps.setString(6, film.getXfplay());
            ps.setString(7, film.getEd2k());
            ps.setString(8, film.getThunder());
            ps.setString(9, film.getQqdl());
            ps.setString(10, film.getFlashGet());
            ps.setInt(11, film.getFilmId());
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(null, ps);
        }
    }

    public void deleteFilm(Integer id) throws Exception {
        String delete = "delete FROM lgw_film  where FILM_ID=?";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw e;
        } finally {
            JDBCSQLite.colseConnection(null, ps);
        }
    }

    public void deleteFilmAll() throws Exception {

        String delete = "delete FROM lgw_film ";

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(delete);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw e;
        } finally {
            JDBCSQLite.colseConnection(null, ps);
        }
    }


    public Film findById(Integer id) {

        String sql = "select * from lgw_film where film_id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Film film = null;
        try {
            conn = JDBCSQLite.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                film = new Film();
                film.setFilmId(resultSet.getInt("film_id"));
                film.setFilmName(resultSet.getString("film_name"));
                film.setFilmType(resultSet.getString("FILM_TYPE"));
                film.setTitleImg(resultSet.getString("title_img"));
                film.setContentImg(resultSet.getString("CONTENT_IGM"));
                film.setHttp(resultSet.getString("http"));
                film.setXfplay(resultSet.getString("xfplay"));
                film.setEd2k(resultSet.getString("ed2k"));
                film.setThunder(resultSet.getString("thunder"));
                film.setQqdl(resultSet.getString("qqdl"));
                film.setFlashGet(resultSet.getString("flashget"));
                film.setUrl(resultSet.getString("url"));
                film.setMd5(resultSet.getString("md5"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, ps);
        }
        return film;

    }

    public List<Film> searchFilm(FilmCondition condition) {
        String where = "";
        if (condition.getFilmName() != null) {
            where += "and film_name like '%" + condition.getFilmName() + "%'";
        }
        String sql = "select * from lgw_film WHERE 1=1 " + where + "  ORDER BY rowid limit ?,?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Film> list = Lists.newArrayList();
        try {
            conn = JDBCSQLite.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, condition.getOffset());
            ps.setInt(2, condition.getPageSize());
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setFilmId(resultSet.getInt("film_id"));
                film.setFilmName(resultSet.getString("film_name"));
                film.setFilmType(resultSet.getString("FILM_TYPE"));
                film.setTitleImg(resultSet.getString("title_img"));
                film.setContentImg(resultSet.getString("CONTENT_IGM"));
                film.setHttp(resultSet.getString("http"));
                film.setXfplay(resultSet.getString("xfplay"));
                film.setEd2k(resultSet.getString("ed2k"));
                film.setThunder(resultSet.getString("thunder"));
                film.setQqdl(resultSet.getString("qqdl"));
                film.setFlashGet(resultSet.getString("flashget"));
                film.setUrl(resultSet.getString("url"));
                film.setMd5(resultSet.getString("md5"));
                list.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, ps);
        }
        return list;
    }

    public int findByCount(FilmCondition condition) {
        String where = "";
        if (condition.getFilmName() != null) {
            where += "and film_name like '%" + condition.getFilmName() + "%'";
        }
        String sql = "select COUNT(1) from lgw_film WHERE 1=1 " + where;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            conn = JDBCSQLite.getConnection();
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, ps);
        }
        return count;
    }


}
