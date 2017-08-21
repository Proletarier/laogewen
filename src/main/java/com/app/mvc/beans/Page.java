package com.app.mvc.beans;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by wenheng on 2017/8/13.
 */
@Getter
@Setter
@ToString
@Builder
public class Page<T> {

    private List<T> data = Lists.newArrayList();

    private int total = 0;

    private int pageNum=1;

}
