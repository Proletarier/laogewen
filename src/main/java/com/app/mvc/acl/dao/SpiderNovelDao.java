package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.po.NovelPage;
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
public class SpiderNovelDao {


    public void insertNovel(List<Novel> novelList) throws Exception {

        String novelSql = "insert into lgw_novel(NOVEL_ID,TYPE_CODE,TITLE,URL,MD5)" +
                "values(NULL,?,?,?,?);";
        String novelPageSql = "insert into lgw_novel_page(NOVEL_PAGE_ID,NOVEL_ID,PAGE,CONTENT)" +
                "values(null,?,?,?,?);";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCSQLite.getConnection();
            conn.setAutoCommit(false);
            for (Novel novel : novelList) {
                statement = conn.prepareStatement(novelSql);
                statement.setString(1, novel.getTypeCode());
                statement.setString(2, novel.getTitle());
                statement.setString(3, novel.getUrl());
                statement.setString(4, novel.getMd5());
                int sum = statement.executeUpdate();
                if (sum == 1) {
                    resultSet = statement.getGeneratedKeys();
                    Integer novelId = resultSet.getInt("novel_id");
                    for (NovelPage page : novel.getNovelPages()) {
                        statement = conn.prepareStatement(novelPageSql);
                        statement.setInt(1, novelId);
                        statement.setInt(2, page.getPage());
                        statement.setString(3, page.getContent());
                        statement.executeUpdate();
                    }
                }
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JDBCSQLite.colseConnection(null, statement);
        }

    }

    public void updateNovel(Novel nove) throws Exception {

    }

    public Novel findById(Integer id) {
        String novelSql = "select * from  lgw_novel WHERE NOVEL_ID=?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Novel novel = null;
        try {
            conn = JDBCSQLite.getConnection();
            statement = conn.prepareStatement(novelSql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                novel = new Novel();
                novel.setMd5(resultSet.getString("md5"));
                novel.setUrl(resultSet.getString("url"));
                novel.setTypeCode(resultSet.getString("TYPE_CODE"));
                novel.setTitle(resultSet.getString("TITLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(null, statement);
        }
        return novel;
    }

    public List<Novel> searchNovel(NovelCondition condition) {
        String where = "";
        if (condition.getTitle() != null) {
            where += " and  TITLE  like '%" + condition.getTitle() + "%'";
        }
        String sql = "select * from lgw_novel where 1=1 " + where + " order by rowid limit ?,?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Novel> novelList = Lists.newArrayList();
        try {
            conn = JDBCSQLite.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, condition.getOffset());
            statement.setInt(2, condition.getPageSize());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Novel novel = new Novel();
                novel.setMd5(resultSet.getString("md5"));
                novel.setUrl(resultSet.getString("url"));
                novel.setTypeCode(resultSet.getString("TYPE_CODE"));
                novel.setTitle(resultSet.getString("TITLE"));
                novelList.add(novel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCSQLite.colseConnection(resultSet, statement);
        }
        return novelList;
    }


}