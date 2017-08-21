package com.app.mvc.spider.model;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * Created by wenheng on 2017/7/16.
 */
public class Queue {

    private LinkedList<Object> queue= Lists.newLinkedList();

    public  void enQueue(Object obj){
        queue.add(obj);
    }

    public  Object deQueue(){
        return queue.removeFirst();
    }

    public boolean contians(Object t){
        return queue.contains(t);
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}
