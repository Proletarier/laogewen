package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.PictureRegexCondition;
import com.app.mvc.acl.po.PictureRegex;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wenheng on 2018/1/6.
 */
@DBRepository
public interface PictureRegexDao {

    void  savePictureRegex(PictureRegex pictureRegex);

    void  updatePictureRegex(PictureRegex pictureRegex);

    PictureRegex searchPictureRegex(@Param("condition")PictureRegexCondition  condition);

    PictureRegex findById(@Param("pictureRegexId") Integer pictureRegexId);


}
