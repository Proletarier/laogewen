package com.app.mvc.beans;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
public class SpiderQueue {
    //已访问过的url队列
    private  Set<String> visitedUrl= Sets.newHashSet();
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


    public Set<String> getVisitedUrl() {
        return visitedUrl;
    }

    public Queue unVisitedUrl(){
        return unVisitedUrl;
    }

    public  String unVisitedUrlDeQueue(){
        return  unVisitedUrl.deQueue();
    }

    public void addUnVisitedUrl(String url){
        if(url!=null && !url.trim().equals("") &&
                !visitedUrl.contains(url) && !unVisitedUrl.contians(url)){
            unVisitedUrl.enQueue(url);
        }
    }

    public  boolean unVisitedUrisEmpty(){
        return unVisitedUrl.empty();
    }
}
