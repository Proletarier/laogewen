layui.config({
    base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    form.on("submit(addNews)",function(data){

        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

        $.ajax(
            {
                type:"POST",
                url:"/resource/film",
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(data.field),
                success: function (result) {
                    if(result.status==1){
                        setTimeout(function(){
                            top.layer.close(index);
                            top.layer.msg("电影添加成功！");
                            layer.closeAll("iframe");
                            parent.location.reload();
                        },2000);
                    }else{
                        layer.msg(result.msg, {time: 2000});
                    }
                }
            }
        );
        return false;
    });

});