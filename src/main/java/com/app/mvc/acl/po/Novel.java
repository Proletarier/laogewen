package com.app.mvc.acl.po;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Novel {

    private  Integer novelId;
    //小说类型
    private  String typeCode;
    //小说标题
    private  String title;
    //小说地址
    private  String fileName;
    //文件地址
    private  Integer resourceId;
    //创建时间
    private  Date createDate;

    private  String typeCodeMeaning;

    private List<NovelPage> novelPages= Lists.newArrayList();

}
