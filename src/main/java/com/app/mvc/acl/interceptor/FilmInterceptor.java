package com.app.mvc.acl.interceptor;

import com.app.mvc.acl.service.FilmService;
import com.app.mvc.acl.service.PictureService;
import com.app.mvc.util.DirectoryFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by wenheng on 2017/8/28.
 */
public class FilmInterceptor implements HandlerInterceptor {

    @Autowired
    FilmService filmService;

    @Autowired
    PictureService pictureService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUrl = request.getRequestURI().toString();

        if (requestUrl.contains("vod") && requestUrl.contains("html") && !requestUrl.contains("play") && !requestUrl.contains("list")) {
            String filName = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
            String dirPath = request.getSession().getServletContext().getRealPath("app/vod/");
            File file = new File(dirPath);
            String[] indexFileList = file.list(new DirectoryFilter(filName));
            if (indexFileList.length <= 0) {
                String id = filName.substring(0, filName.indexOf("."));
                filmService.staticVodHtml(request.getSession().getServletContext().getRealPath(""), Integer.valueOf(id));
            }
        } else if (requestUrl.contains("picture") && requestUrl.contains("html") && !requestUrl.contains("list")) {
            String filName = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
            String dirPath = request.getSession().getServletContext().getRealPath(requestUrl);
            File file = new File(dirPath);
            if (!file.exists()) {
                String id = filName.substring(0, filName.indexOf("."));
                pictureService.staticPictureHtml(request.getSession().getServletContext().getRealPath(""), Integer.valueOf(id));
            }

        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
