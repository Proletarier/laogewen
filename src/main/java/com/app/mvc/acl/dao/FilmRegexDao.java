package com.app.mvc.acl.dao;

import com.app.mvc.acl.po.FilmRegex;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/11.
 */

@DBRepository
public interface FilmRegexDao {

    void  saveFilmRegex(FilmRegex filmRegex);

    void  updateFilmRegex(FilmRegex filmRegex);

    FilmRegex findById(@Param("filmRegexId") Integer id);


}
