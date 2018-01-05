package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.config.FileConfig;
import com.app.mvc.acl.config.utilConfig;
import com.app.mvc.acl.dao.PictureDao;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.beans.Page;
import com.app.mvc.beans.StaticTemplateView;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.FreemakerUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by wenheng on 2017/7/2.
 */

@Slf4j
@Service
public class PictureService {

    @Autowired
    private PictureDao pictureDao;


    public void savePicture(Picture picture) {
        try {
            pictureDao.savePicture(picture);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.ADD.FALL");
        }
    }

    public void updatePicture(Picture picture) {
        try {
            pictureDao.updatePicture(picture);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.UPDATE.FAIL");
        }
    }

    public Picture findById(Integer id) {
        Picture picture = null;
        try {
            picture = pictureDao.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.FIND.IS.FALL");
        }
        return picture;
    }

    public Page<Picture> queryPicture(PictureCondition pictureCondition) {
        Page<Picture> page = null;
        try {
            List<Picture> list = pictureDao.queryPicture(pictureCondition);
            page = Page.<Picture>builder().data(list).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.SEARCH.FAIL");
        }
        return page;
    }

}
