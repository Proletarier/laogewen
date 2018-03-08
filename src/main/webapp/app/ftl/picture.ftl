<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${picture.name} ${picture.codeValue} - 老哥稳</title>
    <meta name="referrer" content="never">
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/public/css/main.css" rel="stylesheet">
    <link href="/app/public/css/picture_details.css" rel="stylesheet"/>
    <script src="/app/public/js/jquery-1.12.0.min.js"></script>
    <script src="/app/public/js/bootstrap.min.js"></script>
    <script src="/app/public/js/main.js"></script>
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