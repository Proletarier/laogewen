package com.app.mvc.common;

import com.app.mvc.beans.JsonData;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;


/**
 * Created by wenheng on 2017/7/6.
 */

@Slf4j
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {

        ModelAndView mv;
        JsonData jsonData;
        try{
            if(ex instanceof ServiceException){
                ServiceException serviceException=(ServiceException)ex;
                jsonData=JsonData.error(serviceException.getResultCode(),serviceException.getAdditionalMessage());
            }else{
                jsonData=JsonData.createError();
            }
            setMessage(jsonData);
            if(request.getRequestURI().contains(".html") || request.getRequestURI().endsWith(".js")) {

            }else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                String result=JacksonUtil.toJSon(jsonData);
                response.getOutputStream().write(result.getBytes(Charset.forName("UTF-8")));
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new ModelAndView();
    }


    private  void setMessage(JsonData jsonData){
        String resultCode = jsonData.getResultCode();
        String message;
        try {
            message=applicationContextHelper.getMessage(resultCode);
            jsonData.setMsg(message);
        }catch (Exception e){
            log.error(e.getMessage());
            jsonData.setMsg("系统异常");
        }

    }

}
