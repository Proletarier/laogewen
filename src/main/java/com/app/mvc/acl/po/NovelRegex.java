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
public class NovelRegex implements java.io.Serializable{

    private Integer novelRegexId;

    private String titleRegex;

    private String typeRegex;

    private String contentRegex;

    private String indexRegex;

    private String description;

    private Date createDate;
}
