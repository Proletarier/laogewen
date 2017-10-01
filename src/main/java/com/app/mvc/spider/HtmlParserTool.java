package com.app.mvc.spider;

import com.app.mvc.spider.filter.LinkFilter;
import com.google.common.collect.Sets;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
public class HtmlParserTool {
    public static Set<String> extracLinks(String url, LinkFilter filter) {
        Set<String> links = Sets.newHashSet();
        try {
            URL realurl = new URL(url);
            URLConnection connection = realurl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setReadTimeout(100000);
            connection.setConnectTimeout(100000);
            Parser parser = new Parser(connection);
            parser.setEncoding("UTF-8");
            //过滤<frame>标签的filter,用来提取frame标签的src属性
            NodeFilter frameFilter = new NodeFilter() {
                @Override
                public boolean accept(Node node) {
                    if (node.getText().startsWith("frame src=")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            OrFilter linkFilter = new OrFilter(new NodeClassFilter(
                    LinkTag.class), frameFilter);
            NodeList list = parser.extractAllNodesThatMatch(linkFilter);
            for (int i = 0; i < list.size(); i++) {
                Node tag = list.elementAt(i);
                if (tag instanceof LinkTag) {
                    LinkTag linkTag = (LinkTag) tag;
                    String linkurl = linkTag.getLink();
                    if (filter.accept(linkurl, "https://9999av.co/html/tupian/yazhou", "https://9999av.co/html/tupian/siwa",
                            "https://9999av.co/html/tupian/oumei",
                            "https://9999av.co/html/tupian/mingxing",
                            "https://9999av.co/html/tupian/qingchun",
                            "https://9999av.co/html/tupian/dongman")) {
                        links.add(linkurl);
                    }
                } else {
                    String fram = tag.getText();
                    int start = fram.indexOf("src=");
                    fram = fram.substring(start);
                    int end = fram.indexOf(" ");
                    if (end == -1) {
                        end = fram.indexOf(">");
                    }
                    String frameUrl = fram.substring(5, end - 1);
                    if (filter.accept(frameUrl, "https://9999av.co/html/tupian/yazhou", "https://9999av.co/html/tupian/siwa",
                            "https://9999av.co/html/tupian/oumei",
                            "https://9999av.co/html/tupian/mingxing",
                            "https://9999av.co/html/tupian/qingchun",
                            "https://9999av.co/html/tupian/dongman")) {
                        links.add(frameUrl);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(url + "链接失败");
            e.printStackTrace();
        }
        return links;

    }
}
