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
@NoArgsConstructor
@AllArgsConstructor
public class Film  implements java.io.Serializable{

    private  Integer filmId;
    //电影类型
    private  String filmType;
    //电影名称
    private  String filmName;
    //图片标题地址
    private  String titleImg;
    //图片内容地址
    private  String contentImg;
    //先锋
    private String  xfplay;
    //http
    private  String  http;
    //ed2k
    private  String ed2k;
    //旋风地址
    private  String qqdl;
    //快车
    private  String flashGet;
    //迅雷下载地址
    private  String thunder;
    //文件地址Resource
    private  Integer titleResourceId;
    private  Integer contentResourceId;
    //点击数量
    private  Integer clickAmount;
    //创建时间
    private  Date createDate;
    //地址
    private  int locationId;

    private  String[] img;

    private String codeValue;
    private String createdBy;
    private String enableFlag;

    private String url;
    private String md5;

}
