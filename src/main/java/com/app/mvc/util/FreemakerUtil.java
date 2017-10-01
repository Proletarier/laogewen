package com.app.mvc.util;

import com.app.mvc.beans.StaticTemplateView;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.io.File;
import java.util.Locale;

/**
 * Created by wenheng on 2017/8/25.
 */
public class FreemakerUtil {

    public static void  freemakerProcess(StaticTemplateView view){
        try {
            Configuration conf=new Configuration();
            conf.setLocale(Locale.CHINA);
            conf.setDefaultEncoding("UTF-8");
            TemplateLoader templateLoader=new FileTemplateLoader(new File(view.getFtlPath()));
            conf.setTemplateLoader(templateLoader);
            Template temp=conf.getTemplate(view.getFltName(),"utf-8");
            File htmlFile=new File(view.getDestPath()+File.separator+view.getDestName());
            if(!htmlFile.exists()){
                FileUtil.createFile(htmlFile, htmlFile.getAbsolutePath());
            }
            Writer out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile),"utf-8"));
            //处理模板
            temp.process(view.getData(),out);
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (TemplateException e){
            e.printStackTrace();
        }

    }
}



















