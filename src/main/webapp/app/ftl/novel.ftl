<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> ${novel.title} ${novel.typeCodeMeaning} - 老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="../public/css/bootstrap.min.css" rel="stylesheet">
    <link href="../main/css/main.css" rel="stylesheet">
    <link href="css/read.css" rel="stylesheet"/>
    <script src="../public/js/jquery-1.12.0.min.js"></script>
    <script src="../public/js/bootstrap.min.js"></script>
    <script src="../main/js/main.js"></script>
</head>
<body>
<div class="container" id="header">
    <div class="head">
        <div class="top">
            <span title="人活着若没有梦想，那和咸鱼又有什么分别呢？">老哥稳，老哥们的修車厂</span>
            <p><a href="">老哥求片留言</a>-<a href="">手机看片方法</a>-<a href="">高速观影指南</a></p>
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
            <a class="gk" rel="nofollow" href="#" target="_blank">网站公告</a>
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
    <div class="main">
        <div class="art_box">
            <h2><a href="/">老哥稳</a>&nbsp;&nbsp;»&nbsp;&nbsp;<a href="/index.html">首页</a>&nbsp;&gt;&nbsp;<a
                    href="/html/tupian/">小说</a>&nbsp;&gt;&nbsp;<a href="/html/tupian/yazhou/">${novel.typeCodeMeaning}</a>
                ${novel.typeCodeMeaning}</h2>
        </div>
        <div class="article" role="article" style="background-color: rgb(247, 248, 237);">
            <!-- 文章内容start -->
            <div class="article-body" role="article-body">
			 ${novelPage.content}
			 <div id="pages">
			 <#if novelPage.page!=1>
			  <a href="/app/novel/${novel.typeCode}/${novel.novelId}.html">首页</a>&nbsp;
			  <a href="/app/novel/${novel.typeCode}/${novelPage.novelId}_${upPageNum}.html">上一页</a>&nbsp;
			 </#if>
			  <#if novelPage.page!=totalNum>
			  <a href="/app/novel/${novel.typeCode}/${novelPage.novelId}_${downPageNum}.html">下一页</a>&nbsp;
			  <a href="/app/novel/${novel.typeCode}/${novel.novelId}_${totalNum}.html">尾页</a>
			 </#if>
			  </div>
            </div>
            <!-- 文章内容end -->
            <div class="pn_news">
                <ul>
                    <li><em>按←键进入上一撸：<a id="pre" href="/html/novel/${novel.typeCode}/${novel.upPage.novelId}.html">${novel.upPage.title}/a></em>
                    </li>
                    <li><em>按→键进入下一撸：<a id="next" href="/html/novel/${novel.typeCode}/${novel.downPage.novelId}.html">${novel.downPage.title}</a></em>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="footer">
        <p>警告：老哥稳含有成人内容！适合20岁以上人群浏览。请遵守当地法律法规不要随意转播！</p>
        <p>如果侵犯了你的权益，请来信通知，我们会及时删除侵权内容，谢谢合作！
            <a class="red" href="#" target="_blank">免责申明</a></p>
        <p>copyright © 2017 HTTPS://WWW.LAOGEWEN.CO老哥稳. all rights reserved. </p>
        <p><font color="#FF0000">声明：老哥稳不接受广告咨询！请勿相信任何渠道！否则上当受骗自负！</font></p>
    </div>
</div>
</div>
</body>
</html>