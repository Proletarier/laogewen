<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${typeCodeMeaning} - 老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/main/css/main.css" rel="stylesheet">
    <link href="/app/vod/css/vod_list.css" rel="stylesheet">
    <script src="/app/public/js/jquery-1.12.0.min.js"></script>
    <script src="/app/public/js/bootstrap.min.js"></script>
    <script src="/app/main/js/main.js"></script>
    <script src="/app/vod/js/vod_list.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
		     var loc = window.location.href;
			 var size = loc.substring(loc.lastIndexOf("/") + 1).replace(/[^0-9]/ig, "");
		     $("#pages b").html("共"+${count}+"部影片 当前:"+size+"/"+Math.ceil(${count}/14)+"页");
			 $(".pagination").html($initPage(size,Math.ceil(${count}/14),"${type}"));
			 $initPageList();
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
    <!-- 广告位 -->
    <div class="banner"></div>
    <div class="clear"></div>
    <div class="newnav">
         <script>
            $(".newnav").load("/app/public/menu.html");
        </script>     
    </div>
    <div class="banner"></div>
    <div id="main">
        <div class="pside">
            <ul class="nav nav-pills nav-stacked ">
                <li class="active"><a href="#">分类检索</a></li>
                <li><a href="/app/vod/YZQS/index_1.html">亚洲情色</a></li>
                <li><a href="/app/vod/ZFSW/index_1.html">制服丝袜</a></li>
                <li><a href="/app/vod/OMXA/index_1.html">欧美性爱</a></li>
                <li><a href="/app/vod/JDSJ/index_1.html">经典三级</a></li>
                <li><a href="/app/vod/LLND/index_1.html">乱伦虐待</a></li>
                <li><a href="/app/vod/LLBT/index_1.html">另类变态</a></li>
                <li><a href="/app/vod/CRDM/index_1.html">成人动漫</a></li>
                <li><a href="/app/vod/ZXSP/index_1.html">在线视频</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="pagelist">
            <div class="filter">
                <div class="title">
                    <b>
                        当前位置：
                        <a href="/">首页</a>
						${typeCodeMeaning}
                    </b>
                </div>
            </div>
            <div class="movielist">
                <div class="pagepre">
                    <p>
                        共找到<span>${count}</span>个视频
                    </p>
                </div>
                <ul class="mlist" id="table_ul">
			    <#list (page) as val>
				 <#if (val.filmType)??>
                    <li style="display:none;">
                        <a class="p" title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmID)?c}.html" target="_blank">
                            <img src="${val.titleImg}" alt="">
                        </a>
                        <div class="info">
                            <h2>
                                <a href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmID)?c}.html" title="${val.filmName}" target="_blank">${val.filmName}</a>
                            </h2>
                            <p><i>更新：${val.createDate?string("yyyy-MM-dd")}</i></p>
                            <p><i>类型：${typeCodeMeaning}</i></p>
                            <p><i>撸量：${val.clickAmount}</i></p>
                            <span>
                                <a href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmID)?c}.html" target="_blank">观看</a>
                                <a href="" target="_blank">下载</a>
                            </span>
                        </div>
                    </li>
				 <#else>
				       <li style="display:none;">
                        <a class="p" title="" href="" target="_blank">
                            <img src="" alt="">
                        </a>
                        <div class="info">
                            <h2>
                                <a href="" title="" target="_blank"></a>
                            </h2>
                            <p><i></i></p>
                            <p><i></i></p>
                            <p><i></i></p>
                            <span>
                                <a href="" target="_blank">观看</a>
                                <a href="" target="_blank">下载</a>
                            </span>
                        </div>
                    </li>
				 </#if>
				</#list>
                </ul>
                <div class="clear"></div>
                <div id="pages">
                    <b></b>
                    <ul class="pagination" style="margin: 0">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="banner"></div>
    <div id="footer">
        <p>警告：老哥稳含有成人内容！适合20岁以上人群浏览。请遵守当地法律法规不要随意转播！</p>
        <p>如果侵犯了你的权益，请来信通知，我们会及时删除侵权内容，谢谢合作！
            <a class="red" href="#" target="_blank">免责申明</a></p>
        <p>copyright ? 2017 HTTPS://WWW.LAOGEWEN.CO老哥稳. all rights reserved. </p>
        <p><font color="#FF0000">声明：老哥稳不接受广告咨询！请勿相信任何渠道！否则上当受骗自负！</font></p>
    </div>
</div>
</body>
</html>