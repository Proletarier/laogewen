<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> ${typeCodeMeaning} - 老哥稳</title>
    <meta name="referrer" content="never">
    <meta name="keyword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
  	<link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
	<link href="/app/public/css/main.css" rel="stylesheet">
	<link href="/app/public/css/read.css" rel="stylesheet"/>
	<script src="/app/public/js/jquery-1.12.0.min.js"></script>
	<script src="/app/public/js/bootstrap.min.js"></script>
	<script src="/app/public/js/main.js"></script>
	<script src="/app/novel/js/novel_list.js"></script>

		<script>
        $(document).ready(function () {
            $initPageList(${count},"${type}");
        });
	</script>
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
                <h2><a href="/">老哥稳</a>&nbsp;&nbsp;»&nbsp;&nbsp;<a href="/index.html">首页</a>&nbsp;&gt;&nbsp;<a href="/html/article/">小说</a>&nbsp;&gt;&nbsp;<a href="/html/novel/jiqing/">${typeCodeMeaning}</a></h2>
                <div class="art">
                    <ul>
                    <#list (page) as val>
					  <#if (val.typeCode)??>
						 <li style="display:none;"><a href='/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.novelId)?c}.html' target="_blank">${val.title}</a> <span>${val.createDate?string("yyyy-MM-dd")}</span></li>
					  <#else>
					     <li style="display:none;"><a href="" target="_blank"></a> <span></span></li>
					  </#if>
					</#list>
                    </ul>
                </div>
                <div class="clear"></div>
                <div id="pages">
                    <b></b>
					<#if pageNum!=1>
					<a id="a1" href="/app/novel/${type}/index_1.html">首页</a>
					<a id="a2" href="/app/novel/${type}/index_${upPageNum}.html">上一页</a>
					</#if>
					<#if pageNum!=totalNum>
                    <a id="a3" href="/app/novel/${type}/index_${downPageNum}.html">下一页</a>
                    <a id="a4" href="/app/novel/${type}/index_${totalNum}.html">尾页</a>
					</#if>
                    转到
                    <input name="page" id="page" size="4" class="pagego" type="input">
                    <input value="跳 转" onclick="window.location='/app/novel/${type}/index_<{page}>.html'.replace('<{page}>', document.getElementById('page').value);" class="pagebtn" type="button">
                </div>
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