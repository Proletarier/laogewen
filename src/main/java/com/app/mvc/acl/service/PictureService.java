package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.entity.Picture;
import com.app.mvc.beans.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by wenheng on 2017/7/2.
 */
public interface PictureService {

    void  savePicture(Picture picture);

    void  updatePicture(Picture picture);

    Picture findById(Integer id);

    Page<Picture> queryPicture(PictureCondition pictureCondition);

    Map<String, List<Picture>> searchHome();

    void  staticPictureHtml(String path,Integer id);

    void  staticPicturePageListHtml(String path,PictureCondition pictureCondition);

    void  staticPicturePageHtml(String path,PictureCondition pictureCondition);

}
