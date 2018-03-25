package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.dao.PictureDao;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */

@Slf4j
@Service
public class PictureService {

    @Autowired
    private PictureDao pictureDao;


    @Transactional
    public void savePicture(Picture picture) {
        try {
            picture.setEnableFlag("Y");
            picture.setCreateDate(new Date());
            pictureDao.savePicture(picture);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.ADD.FALL");
        }
    }

    @Transactional
    public void updatePicture(Picture picture) {

        Picture oldPicture=pictureDao.findById(picture.getPictureId());
        oldPicture.setImg(picture.getImg());
        oldPicture.setTypeCode(picture.getTypeCode());
        oldPicture.setName(picture.getName());
        try {
            pictureDao.updatePicture(oldPicture);
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
            int count=pictureDao.countByPicture(pictureCondition);
            List<Picture> list = pictureDao.queryPicture(pictureCondition);
            page = Page.<Picture>builder().data(list).total(count).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.SEARCH.FAIL");
        }
        return page;
    }

    public void  updateEnableFlag(Integer id,String enableFlag){
         Picture picture=pictureDao.findById(id);
         if(picture==null){
             throw ServiceException.create("PICTURE.FIND.IS.FALL");
         }
         try{
              picture.setEnableFlag(enableFlag);
              pictureDao.updatePicture(picture);
         }catch (Exception e){
             log.error(e.getMessage());
             throw ServiceException.create("PICTURE.UPDATE.FAIL");
         }
    }

    public  void  deletePicture(Integer id){

         try{
             pictureDao.deletePicture(id);
         }catch (Exception e){
             log.error(e.getMessage());
             throw ServiceException.create("PICTURE.UPDATE.FAIL");
         }

    }

}
