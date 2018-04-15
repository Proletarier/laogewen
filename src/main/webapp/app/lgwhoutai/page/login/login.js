layui.use(['form','layer'], function(){
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

	})

	//验证码
    $(".code").on("click",function () {
        $(".code img").attr('src', "/resource/login/captcha?d="+Math.random());
    });
		

});
