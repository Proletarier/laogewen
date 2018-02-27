<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> ${novel.title} ${novel.typeCodeMeaning} - 老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/main/css/main.css" rel="stylesheet">
    <link href="/app/novel/css/read.css" rel="stylesheet"/>
    <script src="/app/public/js/jquery-1.12.0.min.js"></script>
    <script src="/app/public/js/bootstrap.min.js"></script>
    <script src="/app/main/js/main.js"></script>

</head>
<body>
<div class="container" id="header">
    <div class="head">
        <script>
            $(".head").load("/app/public/head.html");
        </script>       
    </div>
    <div class="banner"></div>
    <div class="clear"></div>
    <div class="newnav">
        <script>
            $(".newnav").load("/app/public/menu.html");
        </script>       
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
			  <a href="/app/novel/${novel.typeCode}/${novel.createDate?string("yyyy/MMdd")}/${novel.novelId}.html">首页</a>&nbsp;
			  <#if novelPage.page==2>
			   <a href="/app/novel/${novel.typeCode}/${novel.createDate?string("yyyy/MMdd")}/${novelPage.novelId}.html">上一页</a>&nbsp;
			   <#else>
			   <a href="/app/novel/${novel.typeCode}/${novel.createDate?string("yyyy/MMdd")}/${novelPage.novelId}_${upPageNum}.html">上一页</a>&nbsp;
			  </#if>
			 </#if>
			  <#if novelPage.page!=totalNum>
			  <a href="/app/novel/${novel.typeCode}/${novel.createDate?string("yyyy/MMdd")}/${novelPage.novelId}_${downPageNum}.html">下一页</a>&nbsp;
			  <a href="/app/novel/${novel.typeCode}/${novel.createDate?string("yyyy/MMdd")}/${novel.novelId}_${totalNum}.html">尾页</a>
			 </#if>
			  </div>
            </div>
            <!-- 文章内容end -->
            <div class="pn_news">
                <ul>
				 <#if (novel.upPage)??>
                    <li><em>按←键进入上一撸：<a id="pre" href="/html/novel/${novel.createDate?string("yyyy/MMdd")}/${novel.typeCode}/${novel.upPage.novelId}.html">${novel.upPage.title}/a></em>
				    </li>
				 </#if>
				 <#if (novel.downPage)??>
                    <li><em>按→键进入下一撸：<a id="next" href="/html/novel/${novel.createDate?string("yyyy/MMdd")}/${novel.typeCode}/${novel.downPage.novelId}.html">${novel.downPage.title}</a></em>
                    </li>
				 </#if>
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