package com.app.mvc.util;

/**
 * Created by wenheng on 2018/3/25.
 */
public class ByteUtil {

    public static byte[] toByteArray(Long l) {
        byte[] b = new byte[8];

        for (int i = 0; i < b.length; ++i) {
            b[7 - i] = (byte) ((int) (l.longValue() >>> i * 8));
        }

        return b;
    }

    public static byte[] toByteArray(Integer i) {
        byte[] b = new byte[4];

        for (int j = 0; j < 4; ++j) {
            b[3 - j] = (byte) (i.intValue() >>> j * 8);
        }

        return b;
    }

}
