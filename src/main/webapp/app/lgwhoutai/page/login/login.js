layui.config({
    base : "js/"
}).use(['form','layer','jquery'], function(){
    var  form=layui.form
        ,layer = parent.layer === undefined ? layui.layer : parent.layer
	     $ = layui.jquery;


    $(window).resize(function(){
        if($(".video-player").width() > $(window).width()){
            $(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
        }else{
            $(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
        }
    }).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){

        var index = top.layer.msg('正在登录。。。',{icon: 16,time:false,shade:0.8});
        $.ajax(
            {
                type:"POST",
                url:"/resource/login",
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(data.field),
                success: function (result) {
                    if(result.status==1){
                        setTimeout(function(){
                            top.layer.msg("登陆成功！");
                            top.layer.close(index);
                            window.location.href = "../../index.html";
                            return false;
                        },2000);
                    }else{
                        top.layer.close(index);
                        layer.msg(result.msg, {time: 2000});
                        $(".code img").attr('src', "/resource/login/captcha?d="+Math.random());
                    }
                }
            }
        );
        return false;
	});

	//验证码
    $(".code").on("click",function () {
        $(".code img").attr('src', "/resource/login/captcha?d="+Math.random());
    });
		

});
