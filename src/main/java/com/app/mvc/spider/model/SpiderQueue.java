package com.app.mvc.spider.model;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
public class SpiderQueue {
    //已访问过的url队列
    private  Set<Object> visitedUrl= Sets.newHashSet();
    //待访问url集合
    private Queue unVisitedUrl=new Queue();

    public void  addVisitedUrl(String url){
        visitedUrl.add(url);
    }

    public void  removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }

    public int getVisitedUrlNum(){
        return  visitedUrl.size();
    }


    public Set<Object> getVisitedUrl() {
        return visitedUrl;
    }

    public Object unVisitedUrl(){
        return unVisitedUrl;
    }

    public  Object unVisitedUrlDeQueue(){
        return  unVisitedUrl.deQueue();
    }

    public void addUnVisitedUrl(String url){
        if(url!=null && !url.trim().equals("") &&
                !visitedUrl.contains(url)){
            unVisitedUrl.enQueue(url);
        }
    }

    public  boolean unVisitedUrisEmpty(){
        return unVisitedUrl.empty();
    }
}
