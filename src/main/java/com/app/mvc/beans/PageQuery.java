package com.app.mvc.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by wenheng on 2017/8/6.
 */
@ToString
public class PageQuery {

    @Getter
    @Setter
    private int pageNum=1;

    @Getter
    @Setter
    private int pageSize = 14;

    @Setter
    private int offset;

    public int getOffset() {
        return (pageNum-1)*pageSize;
    }
}
