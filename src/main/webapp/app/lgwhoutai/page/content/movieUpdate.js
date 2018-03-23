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
        $.get("/resource/film",{filmId:parent.$("#filmId").val()},function(data,status,xhr){
            if(status=="success"){
                $('input[name=filmId]').attr('value',data.data.filmId);
                $('input[name=filmName]').attr('value',data.data.filmName);
                $('input[name=titleImg]').attr('value',data.data.titleImg);
                $('input[name=xfplay]').attr('value',data.data.xfplay);
                $('input[name=ed2k]').attr('value',data.data.ed2k);
                $('input[name=qqdl]').attr('value',data.data.qqdl);
                $('input[name=flashGet]').attr('value',data.data.flashGet);
                $('input[name=thunder]').attr('value',data.data.thunder);
                $('textarea[name=contentImg]').val(data.data.contentImg);
                $("select[name=filmType]").val(data.data.filmType);
                form.render('select');
            }
        });
    });

    form.on("submit(updateVod)",function(data){
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax(
            {
                type:"PUT",
                url:"/resource/film",
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(data.field),
                success: function (result) {
                    if(result.status==1){
                        setTimeout(function(){
                            top.layer.msg("电影修改成功！");
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