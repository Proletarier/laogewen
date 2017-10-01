<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${picture.name} ${picture.codeValue} - 老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/main/css/main.css" rel="stylesheet">
    <link href="../css/picture_details.css" rel="stylesheet"/>
    <script src="/app/public/js/jquery-1.12.0.min.js"></script>
    <script src="/app/public/js/bootstrap.min.js"></script>
    <script src="/app/main/js/main.js"></script>
</head>
<body>
<div class="container" id="header">
    <div class="head">
        <div class="top">
            <span title="人活着若没有梦想，那和咸鱼又有什么分别呢？">老哥稳，老哥们的修車厂</span>
            <p><a href="">老哥求片留言</a>-<a href="/app/help/mobile.html">手机看片方法</a>-<a href="/app/help/help.html">高速观影指南</a></p>
        </div>
        <div class="logo">
            <a title="老哥稳 - 看片从这里开始" href="#"></a>
        </div>
        <p class="plus">
            <a class="ph" href="#">排行榜</a>
            <a class="dq" href="#">搜索中心</a>
        </p>
        <div id="search">
            <div class="input-group col-lg-12">
                <input type="text" placeholder="输入影片关键字搜索" class="form-control">
                <div class="input-group-btn " style="padding-right: 3px">
                    <button type="button" class="btn btn-default dropdown-toggle "
                            data-toggle="dropdown"><span class="type">电影</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu  pull-right ">
                        <li value="1">
                            <a>电影</a>
                        </li>
                        <li value="2">
                            <a>图片</a>
                        </li>
                        <li value="3">
                            <a>小说</a>
                        </li>
                    </ul>
                </div>
                <button type="button" class="btn btn-default btn-1g pull-left">
                    <span class="glyphicon glyphicon-search"></span> 搜索
                </button>
            </div>
            <p>三五瓶 - 逼两拳
                <font color="#FF0000">通知：遇到本网站无法访问!请在网址前面加HTTPS://</font></p>
        </div>
        <div class="history">
            <a class="gk" rel="nofollow" href="/app/help/notice.html" target="_blank">网站公告</a>
        </div>
    </div>
    <div class="banner"></div>
    <div class="clear"></div>
    <div class="newnav">
        <div class="navmenu dy">
            <ul class="nav nav-pills ">
                <li class="homea"><a class="sdy">电影</a></li>
                <li><a href="#">电影首页</a></li>
                <li><a href="#">亚洲情色</a></li>
                <li><a href="#">制服丝袜</a></li>
                <li><a href="#">欧美性爱</a></li>
                <li><a href="#">网友自拍</a></li>
                <li><a href="#">经典三级</a></li>
                <li><a href="#">乱伦虐待</a></li>
                <li><a href="#">另类变态</a></li>
                <li><a href="#">成人动漫</a></li>
            </ul>
        </div>
        <div class="navmenu tp">
            <ul class="nav nav-pills">
                <li class="homea"><a class="stp">图片</a></li>
                <li><a href="#">图片首页</a></li>
                <li><a href="#">偷拍自拍</a></li>
                <li><a href="#">亚洲色图</a></li>
                <li><a href="#">丝袜美腿</a></li>
                <li><a href="#">欧美性爱</a></li>
                <li><a href="#">激情明星</a></li>
                <li><a href="#">青春唯美</a></li>
                <li><a href="#">成人动漫</a></li>
            </ul>
        </div>
        <div class="navmenu xs">
            <ul class="nav nav-pills">
                <li class="homea"><a class="sxs">小说</a></li>
                <li><a href="#">小说首页</a></li>
                <li><a href="#">激情文学</a></li>
                <li><a href="#">乱伦文学</a></li>
                <li><a href="#">明星校园</a></li>
                <li><a href="#">武侠古典</a></li>
                <li><a href="#">黄色笑话</a></li>
                <li><a href="#">性爱技巧</a></li>
            </ul>
        </div>
        <div class="navmenu zx">
            <ul class="nav nav-pills">
                <li class="homea"><a class="szx">在线</a></li>
                <li><a href="#">在线视频</a></li>
                <li><a href="#">亚洲情色</a></li>
                <li><a href="#">制服丝袜</a></li>
                <li><a href="#">欧美性爱</a></li>
                <li><a href="#">网友自拍</a></li>
                <li><a href="#">成人动漫</a></li>
            </ul>
        </div>
    </div>
    <div class="banner"></div>
    <div id="main">
        <div class="artlist">
            <div class="art_box">
                <h2><a href="/">老哥稳</a>&nbsp;&nbsp;»&nbsp;&nbsp;<a href="/index.html">首页</a>&nbsp;&gt;&nbsp;<a
                        href="/html/tupian/">图库</a>&nbsp;&gt;&nbsp;<a href="/html/tupian/yazhou/">${picture.codeValue}</a>
                    ${picture.name}</h2>
                <div class="artbody imgbody">
					<#list (picture.imgs) as val>
                    <p><img src="${val}"></p>
					</#list>
                    <p></p>
                    <div id="pages"></div>
                </div>
            </div>
            <!--/box-->
            <div class="pn_news">
                <ul>
				<#if picture.upPage??>
                    <li>
					   <em>按←键进入上一撸：
					       <a id="pre" href="/app/picture/${picture.typeCode}/${picture.upPage.pictureId}.html">${picture.upPage.name}</a>
					   </em>
					</li>
				</#if>
				<#if picture.downPage??>
					<li>
					   <em>按→键进入下一撸：
					       <a id="pre" href="/app/picture/${picture.typeCode}/${picture.downPage.pictureId}.html">${picture.downPage.name}</a>
					   </em>
					</li>
				</#if>
                </ul>
            </div>
        </div>
    </div>
    <div class="banner"></div>
    <div id="footer">
        <p>警告：老哥稳含有成人内容！适合20岁以上人群浏览。请遵守当地法律法规不要随意转播！</p>
        <p>如果侵犯了你的权益，请来信通知，我们会及时删除侵权内容，谢谢合作！
            <a class="red" href="#" target="_blank">免责申明</a></p>
        <p>copyright © 2017 HTTPS://WWW.LAOGEWEN.CO老哥稳. all rights reserved. </p>
        <p><font color="#FF0000">声明：老哥稳不接受广告咨询！请勿相信任何渠道！否则上当受骗自负！</font></p>
    </div>
</div>
</body>
</html>