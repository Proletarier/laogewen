package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.entity.Picture;
import com.app.mvc.beans.Page;

/**
 * Created by wenheng on 2017/7/2.
 */
public interface PictureService {

    void  savePicture(Picture picture);

    void  updatePicture(Picture picture);

    Picture findById(Integer id);

    Page<Picture> queryPicture(PictureCondition pictureCondition);

}
