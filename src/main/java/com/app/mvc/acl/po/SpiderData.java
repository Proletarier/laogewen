package com.app.mvc.acl.po;

import lombok.*;

/**
 * Created by wenheng on 2018/4/7.
 */

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpiderData {

    private Integer spiderId;
    private String spiderUrl;
    private String spiderMd5;
    private String spiderLocation;
    private String spiderType;
    private String createDate;


}
