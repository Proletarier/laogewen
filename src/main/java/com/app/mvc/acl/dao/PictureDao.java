package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.entity.Picture;
import com.app.mvc.cmmon.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */
@DBRepository
public interface PictureDao {

    void  savePicture(Picture picture);

    void  updatePicture(Picture picture);

    Picture findById(@Param("id") Integer id);

    List<Picture> queryPicture(@Param("condition") PictureCondition pictureCondition);

}
