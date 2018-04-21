/**
 * Created by wenheng on 2018/4/14.
 */
layui.config({
    base : "js/"
}).use(['form','layer','element'],function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        element = layui.element
        $ = layui.jquery;

    layer.ready(function(){

        if (!!window.EventSource) {
            var source = new EventSource('/resource/spider/getVod');
            s = '';
            source.addEventListener('message', function(e) {
            });
            source.addEventListener('open', function(e) {
                console.log("连接打开.");
            }, false);
            source.addEventListener('error', function(e) {
                if (e.readyState == EventSource.CLOSED) {
                    console.log("连接关闭");
                } else {
                    console.log(e.readyState);
                }
            }, false);
        } else {
            alert(4);
            console.log("没有sse");
        }


        var n = 0, timer = setInterval(function(){
            n = n + Math.random()*10|0;
            if(n>100){
                n = 100;
                clearInterval(timer);
            }
            flushNameAndProgress ("最新加勒比 030318-615 工作胸部断奶~裁缝编~[深美せ",n);
        }, 300+Math.random()*1000);


    });

    function flushNameAndProgress (name,size) {

        if($("#laoge").children().length>10){
            $("#laoge p:first").remove();
        }
        $(".name").find("p:last").after("<p>"+name+size+"</p>");

        //重新设置进度条
        element.progress('demo', size+'%');
    }


});

