package com.app.mvc.exception;

/**
 * Created by wenheng on 2017/7/5.
 */
public class ServiceException extends  RuntimeException {

    private static final long serialVersionUID = 1L;
    private  String resultCode;
    private  String message;

    protected  ServiceException(){
        super();
    }

    private  ServiceException(String resultCode,String message){
         this.resultCode=resultCode;
         this.message=message;
    }

    public static ServiceException create(String resultCode){
         return new ServiceException(resultCode,"");
    }

    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
















