layui.config({
    base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;


    layer.ready(function(){
        $.get("/resource/FilmRegex",{id:parent.$("#filmRegexId").val()},function(data,status,xhr){
            if(status=="success"){
                $('input[name=filmRegexId]').attr('value',data.data.filmRegexId);
                $('input[name=titleRegex]').attr('value',data.data.titleRegex);
                $('input[name=typeRegex]').attr('value',data.data.typeRegex);
                $('input[name=titleImgRegex]').attr('value',data.data.titleImgRegex);
                $('input[name=contentImgRegex]').attr('value',data.data.contentImgRegex);
                $('input[name=xfplayRegex]').attr('value',data.data.xfplayRegex);
                $('input[name=httpRegex]').attr('value',data.data.httpRegex);
                $('input[name=qqdlRegex]').attr('value',data.data.ed2kRegex);
                $('input[name=thunderRegex]').attr('value',data.data.thunderRegex);
                $('input[name=qqdlRegex]').attr('value',data.data.qqdlRegex);
                $('input[name=flashgetRegex]').attr('value',data.data.flashgetRegex);
                $('textarea[name=description]').val(data.data.description);
            }
        });
    });

    form.on("submit(updateVod)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax(
            {
                type:"PUT",
                url:"/resource/FilmRegex",
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(data.field),
                success: function (result) {
                    if(result.status==1){
                        setTimeout(function(){
                            top.layer.msg("修改成功！");
                            top.layer.close(index);
                            layer.closeAll("iframe");
                            parent.location.reload();
                        },2000);
                    }else{
                        top.layer.close(index);
                        layer.msg(result.msg, {time: 2000});
                    }
                }
            }
        );
        return false;
    });

});