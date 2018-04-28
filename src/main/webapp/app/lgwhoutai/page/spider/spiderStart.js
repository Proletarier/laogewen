/**
 * Created by wenheng on 2018/4/14.
 */
layui.config({
    base : "js/"
}).use(['form','layer'],function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;

    layer.ready(function(){
        $.get(window.location.search.split("=")[1],function(data,status,xhr) {
                if(status=='success'){
                    var regexs=data.data;
                    for (x in  regexs){
                            $("#spiderRegex").append('<option value="'+regexs[x].filmRegexId+'">'+regexs[x].description+'</option>');
                    }
                    form.render('select');
                }
        })});
});
