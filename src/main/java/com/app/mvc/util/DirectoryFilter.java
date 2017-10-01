package com.app.mvc.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by wenheng on 2017/8/28.
 */
public class DirectoryFilter implements FilenameFilter {

    String myString;

    public  DirectoryFilter(String myString){
         this.myString=myString;
    }


    @Override
    public boolean accept(File dir, String name) {
        String f= new File(name).getName();
        if(f.contains(myString) || f.equals(myString)){
            return true;
        }
        return false;
    }

}
