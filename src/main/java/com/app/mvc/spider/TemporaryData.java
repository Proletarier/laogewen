package com.app.mvc.spider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/21.
 */
public  class   TemporaryData<T> {


    private  Map<String,List<T>> spiderData= Maps.newConcurrentMap();//数据

    private  Map<String,Integer> spiderSize= Maps.newConcurrentMap();//条件


    public  List<T> getList(String key){
         return !spiderData.containsKey(key)? spiderData.put(key,Lists.<T>newArrayList()) : spiderData.get(key);
    }


    public void  removeList(String key){
        if(spiderData.containsKey(key)){
            spiderData.remove(key);
            spiderSize.remove(key);
        }
    }


    public  boolean  isSpiderWorking(String key){
        return spiderData.containsKey(key);
    }


    public  void createSpider(String key,Integer condition){
        if(!spiderData.containsKey(key)){
            spiderData.put(key,Lists.<T>newArrayList());
        }

        if(!spiderSize.containsKey(key)){
            spiderSize.put(key,condition);
        }
    }


    public Integer getCondition(String key){
         return spiderSize.containsKey(key)? spiderSize.get(key) : 0;
    }





}
