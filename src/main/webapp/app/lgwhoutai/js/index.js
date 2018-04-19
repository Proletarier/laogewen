var $,tab,skyconsWeather;
layui.config({
    base : "js/"
}).use(['bodyTab','form','element','layer','jquery','table'],function(){
     var form = layui.form,
        layer = layui.layer,
         table = layui.table,
        element = layui.element;
    $ = layui.jquery;
    tab = layui.bodyTab({
        openTabNum : "50",  //最大可打开窗口数量
        url : "json/navs.json" //获取菜单json地址
    });


    //渲染左侧菜单
    tab.render();

    // 添加新窗口
    $("body").on("click",".layui-nav .layui-nav-item a",function(){
        //如果不存在子级
        if($(this).siblings().length == 0){
            addTab($(this));
            $('body').removeClass('site-mobile');  //移动端点击菜单关闭菜单层
        }
        $(this).parent("li").siblings().removeClass("layui-nav-itemed");
    });

    //隐藏左侧导航
    $(".hideMenu").click(function(){
        $(".layui-layout-admin").toggleClass("showMenu");
        //渲染顶部窗口
        tab.tabMove();
        table.render();
    });

    //刷新当前
    $(".refresh").on("click",function(){
        if($(this).hasClass("refreshThis")){
            $(this).removeClass("refreshThis");
            $(".clildFrame .layui-tab-item.layui-show").find("iframe")[0].contentWindow.location.reload(true);
            setTimeout(function(){
                $(".refresh").addClass("refreshThis");
            },2000)
        }else{
            layer.msg("您点击的速度超过了服务器的响应速度，还是等两秒再刷新吧！");
        }
    });

    //关闭其他
    $(".closePageOther").on("click",function(){
        if($("#top_tabs li").length>2 && $("#top_tabs li.layui-this cite").text()!="后台首页"){
            var menu = JSON.parse(window.sessionStorage.getItem("menu"));
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    //此处将当前窗口重新获取放入session，避免一个个删除来回循环造成的不必要工作量
                    for(var i=0;i<menu.length;i++){
                        if($("#top_tabs li.layui-this cite").text() == menu[i].title){
                            menu.splice(0,menu.length,menu[i]);
                            window.sessionStorage.setItem("menu",JSON.stringify(menu));
                        }
                    }
                }
            })
        }else if($("#top_tabs li.layui-this cite").text()=="后台首页" && $("#top_tabs li").length>1){
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    window.sessionStorage.removeItem("menu");
                    menu = [];
                    window.sessionStorage.removeItem("curmenu");
                }
            })
        }else{
            layer.msg("没有可以关闭的窗口了@_@");
        }
        //渲染顶部窗口
        tab.tabMove();
    });

    //关闭全部
    $(".closePageAll").on("click",function(){
        if($("#top_tabs li").length > 1){
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != ''){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    window.sessionStorage.removeItem("menu");
                    menu = [];
                    window.sessionStorage.removeItem("curmenu");
                }
            })
        }else{
            layer.msg("没有可以关闭的窗口了@_@");
        }
        //渲染顶部窗口
        tab.tabMove();
    });


    //锁屏
    function lockPage(){
        layer.open({
            title : false,
            type : 1,
            content : '	<div class="admin-header-lock" id="lock-box">'+
            '<div class="admin-header-lock-img"><img src="images/admin.jpg"/></div>'+
            '<div class="admin-header-lock-name" id="lockUserName">老哥稳</div>'+
            '<div class="input_btn">'+
            '<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />'+
            '<button class="layui-btn" id="unlock">解锁</button>'+
            '</div>'+
            '<p>请输入“123456”，否则不会解锁成功哦！！！</p>'+
            '</div>',
            closeBtn : 0,
            shade : 0.9
        })
        $(".admin-header-lock-input").focus();
    }
    $(".lockcms").on("click",function(){
        window.sessionStorage.setItem("lockcms",true);
        lockPage();
    })
    // 判断是否显示锁屏
    if(window.sessionStorage.getItem("lockcms") == "true"){
        lockPage();
    }
    // 解锁
    $("body").on("click","#unlock",function(){
        if($(this).siblings(".admin-header-lock-input").val() == ''){
            layer.msg("请输入解锁密码！");
            $(this).siblings(".admin-header-lock-input").focus();
        }else{
            if($(this).siblings(".admin-header-lock-input").val() == "123456"){
                window.sessionStorage.setItem("lockcms",false);
                $(this).siblings(".admin-header-lock-input").val('');
                layer.closeAll("page");
            }else{
                layer.msg("密码错误，请重新输入！");
                $(this).siblings(".admin-header-lock-input").val('').focus();
            }
        }
    });


});

function addTab(_this){
    tab.tabAdd(_this);
}