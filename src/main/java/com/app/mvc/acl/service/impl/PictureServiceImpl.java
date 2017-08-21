package com.app.mvc.acl.service.impl;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.dao.PictureDao;
import com.app.mvc.acl.entity.Picture;
import com.app.mvc.acl.service.PictureService;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */

@Slf4j
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    public void savePicture(Picture picture) {
        try {
            pictureDao.savePicture(picture);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.ADD.FALL");
        }
    }

    public void updatePicture(Picture picture) {
        try {
            pictureDao.updatePicture(picture);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.UPDATE.FAIL");
        }
    }

    public Picture findById(Integer id) {
        Picture picture=null;
        try {
            picture=pictureDao.findById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.FIND.IS.FALL");
        }
        return picture;
    }

    public Page<Picture> queryPicture(PictureCondition pictureCondition) {
        Page<Picture>  page=null;
        try {
            List<Picture> list=pictureDao.queryPicture(pictureCondition);
            page=Page.<Picture>builder().data(list).build();
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.SEARCH.FAIL");
        }
        return page;
    }
}
