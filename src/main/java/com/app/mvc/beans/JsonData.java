package com.app.mvc.beans;

import java.io.Serializable;
/**
 * Created by wenheng on 2017/7/5.
 */
public class JsonData implements Serializable{

    @SuppressWarnings("compatibility:1761488547724600777")
    private static final long serialVersionUID = -6317348280525129379L;

    private final boolean ret;
    private String msg;
    private Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData error(String msg) {
        JsonData result = new JsonData(false);
        result.msg = msg;
        return result;
    }

    public static JsonData success(Object data, String msg) {
        JsonData resulst = new JsonData(true);
        resulst.data = data;
        resulst.msg = msg;
        return resulst;
    }

    public static JsonData success(Object data) {
        JsonData result = new JsonData(true);
        result.data = data;
        return result;
    }

    public boolean getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

}
