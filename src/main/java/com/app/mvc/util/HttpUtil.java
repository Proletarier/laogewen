package com.app.mvc.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wenheng on 2017/12/22.
 */

@Slf4j
public class HttpUtil {

    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realurl = new URL(url);
            URLConnection connection = realurl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setReadTimeout(1000000);
            connection.setConnectTimeout(1000000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"
            ));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


}
