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
public class PictureRegex implements java.io.Serializable {

    private Integer pictureRegexId;

    private String nameRegex;

    private String typeRegex;

    private String imgRegex;

    private String description;

    private Date createDate;
}
