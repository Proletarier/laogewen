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
        $.get("/resource/PictureRegex",{id:parent.$("#pictureRegexId").val()},function(data,status,xhr){
            if(status=="success"){
                $('input[name=nameRegex]').attr('value',data.data.nameRegex);
                $('input[name=typeRegex]').attr('value',data.data.typeRegex);
                $('input[name=imgRegex]').attr('value',data.data.imgRegex);
                $('input[name=pictureRegexId]').attr('value',data.data.pictureRegexId);
                $('textarea[name=description]').val(data.data.description);
            }
        });
    });

    form.on("submit(updatePic)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax(
            {
                type:"PUT",
                url:"/resource/PictureRegex",
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