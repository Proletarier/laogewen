package com.app.mvc.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * Created by wenheng on 2017/8/25.
 */
@Getter
@Setter
@ToString
public class StaticTemplateView {

    private String basePath;
    private String ftlPath;
    private String fltName;
    private String destPath;
    private String destName;
    private Map<String,Object> data;
















}
