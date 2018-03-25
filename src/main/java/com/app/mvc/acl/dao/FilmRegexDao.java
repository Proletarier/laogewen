package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.FilmRegexCondition;
import com.app.mvc.acl.po.FilmRegex;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2018/1/6.
 */
@DBRepository
public interface FilmRegexDao {

    void  saveFilmRegex(FilmRegex filmRegex);

    void  updateFilmRegex(FilmRegex filmRegex);

    FilmRegex findById(@Param("filmRegexId") Integer id);

    List<FilmRegex> searchFilmRegex(@Param("condition") FilmRegexCondition condition);

    int countByFilmRegex(@Param("filmCondition") FilmRegexCondition condition);

    void  deleteFilmRegex(@Param("filmRegexId") Integer id);

}
