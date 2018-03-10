package com.app.mvc.exception;

/**
 * Created by wenheng on 2017/7/5.
 */
public class ServiceException extends  RuntimeException {

    private static final long serialVersionUID = 1L;
    private  String resultCode;
    private  String message;
    private  Object[] additionalMessage;

    protected  ServiceException(){
        super();
    }

    private  ServiceException(String resultCode,String message){
         this.resultCode=resultCode;
         this.message=message;
    }

    public ServiceException(String resultCode,String message, Object[] additionalMessage){
        this.resultCode=resultCode;
        this.message=message;
        this.additionalMessage=additionalMessage;
    }

    /**
     * 根据结果码创建异常
     * @param resultCode
     * @return
     */
    public static ServiceException create(String resultCode){
        return new ServiceException(resultCode,"");
    }

    public static  ServiceException create(String resultCode,String message,Object[] additionalMessage){
       return new ServiceException(resultCode,"",additionalMessage);
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
















