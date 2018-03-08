package com.app.mvc.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenheng on 2017/8/5.
 */
public class FileUtil {

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter file = new FileWriter(fileName, true);
            file.write(content);
            file.write("\r\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createFolder(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception ex) {
            System.err.println("Make Folder Error:" + ex.getMessage());
        }
    }


    public static void createFile(File file, String filePath) {
        int potPos = filePath.lastIndexOf('\\') + 1;
        String folderPath = filePath.substring(0, potPos);
        createFolder(folderPath);
        FileOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            fileInputStream = new FileInputStream(file);
            byte[] by = new byte[1024];
            int c;
            while ((c = fileInputStream.read(by)) != -1) {
                outputStream.write(by, 0, c);
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File[] searchFile(File folder, final String keyWord) {// 递归查找包含关键字的文件

        File[] subFolders = folder.listFiles(new FileFilter() {// 运用内部匿名类获得文件
            @Override
            public boolean accept(File pathname) {// 实现FileFilter类的accept方法
                if (pathname.isDirectory()
                        || (pathname.isFile() && pathname.getName().toLowerCase().contains(keyWord.toLowerCase())))// 目录或文件包含关键字
                    return true;
                return false;
            }
        });

        List<File> result = new ArrayList<File>();// 声明一个集合
        for (int i = 0; i < subFolders.length; i++) {// 循环显示文件夹或文件
            if (subFolders[i].isFile()) {// 如果是文件则将文件添加到结果列表中
                result.add(subFolders[i]);
            } else {// 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
                File[] foldResult = searchFile(subFolders[i], keyWord);
                for (int j = 0; j < foldResult.length; j++) {// 循环显示文件
                    result.add(foldResult[j]);// 文件保存到集合中
                }
            }
        }

        File files[] = new File[result.size()];// 声明文件数组，长度为集合的长度
        result.toArray(files);// 集合数组化
        return files;
    }


    public static void main(String... args) {
        String requestUrl = "laogewen/vod/123.html";
        String filName = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
        System.out.print(filName);
    }


}