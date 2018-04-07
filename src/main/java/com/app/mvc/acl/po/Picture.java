package com.app.mvc.acl.po;

import lombok.*;

import java.util.Date;

/**
 * Created by wenheng on 2017/7/2.
 */

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Picture implements java.io.Serializable{

    private  Integer pictureId;
    //图片名称
    private  String  name;
    //图片类型
    private  String typeCode;
    //图片地址
    private  String img;
    //文件地址
    private  Integer resourceId;
    //创建时间
    private Date createDate;

    private String enableFlag;

    private String createdBy;

    private Integer locationId;

    private String codeValue;

    private Picture upPage;
    private Picture downPage;

    private String[] imgs;

    private String resourceMeaning;

    private String url;
    private String md5;


}





















