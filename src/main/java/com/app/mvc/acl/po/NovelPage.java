package com.app.mvc.acl.po;

import lombok.*;

/**
 * Created by wenheng on 2018/1/1.
 */
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NovelPage implements java.io.Serializable {

    private  Integer novelPageId;
    private  Integer novelId;
    private  Integer page;
    private  String  content;

}
