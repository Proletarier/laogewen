package com.app.mvc.beans;

import java.io.Serializable;
/**
 * Created by wenheng on 2017/7/5.
 */
public class JsonData implements Serializable{

    @SuppressWarnings("compatibility:1761488547724600777")
    private static final long serialVersionUID = -6317348280525129379L;

    private int status;
    private String msg;
    private Object data;
    private Integer total;
    private String resultCode;
    private Object[] additionalMessage;

    /**
     *    状态码
     * 1：业务成功
     * 2：业务失败
     * 3：系统异常  未处理的异常
     * 4：未登录
     * 5：无权限
     * 6：请求失效,可能是因为超时或者重复提交
     * 7：签名错误
     */
    private JsonData(int status,String resultCode,String message,Object data,Object[] additionalMessage){
        this.status=status;
        this.msg=message;
        this.data=data;
        this.resultCode=resultCode;
        this.additionalMessage=additionalMessage;
    }

    private JsonData(int status,String message,Object data,Integer total){
        this.status=status;
        this.msg=message;
        this.data=data;
        this.total=total;
    }

    public static  JsonData success(){
        return  new JsonData(1,"0","成功",null,null);
    }

    public static JsonData success(Object data) {
        return  new JsonData(1,"0","成功",data,null);
    }

    public static JsonData success(Object data,Integer total) {
        return  new JsonData(1,"成功",data,total);
    }



    public static JsonData createSignError() {
        return JsonData.error(7, "PUBLIC.SIGN.ERROR");
    }

    public static JsonData createRequestTimeout() {
        return JsonData.error(6, "PUBLIC.REQUEST.TIMEOUT");
    }

    public static JsonData createNotAuthorized() {
        return JsonData.error(5, "PUBLIC.SYSTEM.NOT.AUTHORIZED");
    }

    public static JsonData createNotLogin() {
        return JsonData.error(4, "PUBLIC.SYSTEM.NOT.LOGIN");
    }

    public static JsonData createError() {
        return JsonData.error(3, "PUBLIC.SYSTEM.ERROR");
    }


    public static JsonData error(String resultCode,Object[] additionalMessage){
        return   new JsonData(2,resultCode,null,null,additionalMessage);
    }

    public static  JsonData error(int status,String resultCode){
        return   new JsonData(status,resultCode,null,null,null);
    }




    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object[] getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(Object[] additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
}
