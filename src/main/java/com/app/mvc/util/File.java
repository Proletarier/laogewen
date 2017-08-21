package com.app.mvc.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wenheng on 2017/8/5.
 */
public class File {

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter file=new FileWriter(fileName,true);
            file.write(content);
            file.write("\r\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}