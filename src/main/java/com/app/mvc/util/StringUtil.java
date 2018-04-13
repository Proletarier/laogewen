package com.app.mvc.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wenheng on 2018/3/25.
 */
public class StringUtil {

    public static final String LINE_SEP = System.getProperty("line.SEPARATOR");

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isWhitespace(char c) {
        return c == 32;
    }

    public static boolean isFullHalfWidthSpace(char c) {
        return c == 12288 || c == 32;
    }

    public static String reverse(String encode){
        return  encode==null? null:(new StringBuffer(encode)).reverse().toString();
    }

    public static String rtrim(String str) {
        if (str == null) {
            return null;
        } else {
            int length;
            for (length = str.length(); 0 < length && isWhitespace(str.charAt(length - 1)); --length) {
                ;
            }

            return length < str.length() ? str.substring(0, length) : str;
        }
    }

    public static String ltrim(String str) {
        if (str == null) {
            return null;
        } else {
            int start = 0;

            int length;
            for (length = str.length(); start < length && isWhitespace(str.charAt(start)); ++start) {
                ;
            }

            return start > 0 ? str.substring(start, length) : str;
        }
    }

    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    public static String dump(Map<?, ?> map) {
        if (map == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(LINE_SEP);
            sb.append("Map{");
            sb.append(LINE_SEP);

            for (Iterator it = map.keySet().iterator(); it.hasNext(); sb.append(LINE_SEP)) {
                Object key = it.next();
                String appendKey = null;
                if (key == null) {
                    appendKey = "null";
                } else {
                    appendKey = key.toString();
                }

                sb.append(appendKey);
                sb.append('=');
                Object valueObj = map.get(key);
                if (valueObj == null) {
                    sb.append("null");
                } else if (valueObj.getClass().isArray()) {
                    sb.append(getArraysStr((Object[]) ((Object[]) valueObj)));
                } else {
                    sb.append(valueObj.toString());
                }
            }

            sb.append("}");
            return sb.toString();
        }
    }

    public static String getArraysStr(Object[] arrayObj) {
        return ArrayUtils.toString(arrayObj, (String) null);
    }

    public static String getExtension(String name) {
        int index = name.lastIndexOf(46);
        return index < 0 ? "" : name.substring(index);
    }

    public static String toShortClassName(String longClassName) {
        return ClassUtils.getShortClassName(longClassName);
    }

    public static String toHexString(byte[] byteArray) {
        return toHexString(byteArray, (String) null);
    }

    public static String toHexString(byte[] byteArray, String delim) {
        if (delim == null) {
            delim = "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < byteArray.length; ++i) {
            if (i > 0) {
                sb.append(delim);
            }

            String hex = Integer.toHexString(byteArray[i] & 255).toLowerCase();
            if (hex.length() < 2) {
                sb.append("0");
            }

            sb.append(hex);
        }

        return sb.toString();
    }

    public static String toHexString(Integer i) {
        return toHexString(ByteUtil.toByteArray(i));
    }

    public static String toHexString(Long l) {
        return toHexString(ByteUtil.toByteArray(l));
    }

    public static String capitalizeInitial(String str) {
        if (str != null && !"".equals(str)) {
            char[] chars = str.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return new String(chars);
        } else {
            return str;
        }
    }

    public static String encodeURL(String s, String enc) {
        try {
            return s == null ? null : URLEncoder.encode(s, enc);
        } catch (UnsupportedEncodingException var3) {
            return null;
        }
    }

    public static String encodeURL(String s) {
        return encodeURL(s, "UTF-8");
    }

    public static String decodeURL(String s, String enc) {
        try {
            return s == null ? null : URLDecoder.decode(s, enc);
        } catch (UnsupportedEncodingException var3) {
            return null;
        }
    }

    public static String decodeURL(String s) {
        return decodeURL(s, "UTF-8");
    }

    public static String filter(String str) {
        char[] cbuf = str.toCharArray();
        StringBuilder sbui = new StringBuilder();

        for (int i = 0; i < cbuf.length; ++i) {
            if (cbuf[i] == 38) {
                sbui.append("&amp;");
            } else if (cbuf[i] == 60) {
                sbui.append("&lt;");
            } else if (cbuf[i] == 62) {
                sbui.append("&gt;");
            } else if (cbuf[i] == 34) {
                sbui.append("&quot;");
            } else if (cbuf[i] == 39) {
                sbui.append("&#39;");
            } else {
                sbui.append(cbuf[i]);
            }
        }

        return sbui.toString();
    }

    public static int getByteLength(String value, String encoding) throws UnsupportedEncodingException {
        if (value != null && !"".equals(value)) {
            Object bytes = null;
            byte[] bytes1;
            if (encoding != null && !"".equals(encoding)) {
                try {
                    bytes1 = value.getBytes(encoding);
                } catch (UnsupportedEncodingException var4) {
                    throw var4;
                }
            } else {
                bytes1 = value.getBytes();
            }

            return bytes1 == null ? 0 : bytes1.length;
        } else {
            return 0;
        }
    }

    public static String join(Collection<? extends CharSequence> coll, String delimiter) {
        if (coll == null) {
            return null;
        } else if (coll.isEmpty()) {
            return "";
        } else {
            Iterator iter = coll.iterator();
            StringBuilder sb = new StringBuilder((CharSequence) iter.next());

            while (iter.hasNext()) {
                sb.append(delimiter);
                sb.append((CharSequence) iter.next());
            }

            return sb.toString();
        }
    }

    public static String join(CharSequence[] array, String delimiter) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder(array[0]);

            for (int i = 1; i < array.length; ++i) {
                sb.append(delimiter);
                sb.append(array[i]);
            }

            return sb.toString();
        }
    }

    public static List<Integer> splierToListInt(String str) {
        List<String> strList = Splitter.on(",").splitToList(str);
        List<Integer> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(strList)) {
            return list;
        }
        for (String s : strList) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }
}
