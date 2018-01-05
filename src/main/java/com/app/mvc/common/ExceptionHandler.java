package com.app.mvc.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerException;


/**
 * Created by wenheng on 2017/7/6.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

        ModelAndView mv;

        if (ex instanceof ServerException) {
            mv = new ModelAndView();
        } else {
            mv = new ModelAndView();
        }

        return mv;
    }
}
