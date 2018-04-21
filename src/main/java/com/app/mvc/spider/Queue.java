package com.app.mvc.spider;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * Created by wenheng on 2017/7/16.
 */
public class Queue {

    private LinkedList<String> queue= Lists.newLinkedList();

    public  void enQueue(String obj){
        queue.add(obj);
    }

    public  String deQueue(){
        return queue.removeFirst();
    }

    public boolean contians(String t){
        return queue.contains(t);
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}
