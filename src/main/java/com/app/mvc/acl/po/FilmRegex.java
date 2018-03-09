package com.app.mvc.acl.po;

import lombok.*;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/5.
 */
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmRegex implements java.io.Serializable{

    private Integer filmRegexId;

    private String titleRegex;

    private String typeRegex;

    private String titleImgRegex;

    private String contentImgRegex;

    private String xfplayRegex;

    private String httpRegex;

    private String ed2kRegex;

    private String qqdlRegex;

    private String flashgetRegex;

    private String description;

    private Date creationDate;
}
