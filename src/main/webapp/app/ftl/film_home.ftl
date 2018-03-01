<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>老哥稳影院</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/public/css/main.css" rel="stylesheet">
    <link href="/app/public/css/vod_details.css" rel="stylesheet"/>
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
    <!-- 广告位 -->
    <div class="banner"></div>
    <div class="clear"></div>
    <div class="newnav">
        <script>
            $(".newnav").load("/app/public/menu.html");
        </script>
    </div>
    <div class="banner"></div>
    <div class="main">
        <div class="trailers mt10">
            <div class="title">
                <b>
                    <a style="color: #06a6e2" href="#" target="_blank">为您推荐</a>
                </b>
                全部<i>${count}</i>部>>
            </div>
            <ul class="img-list">
			<#list (wntj) as film>
                <li>
                    <a class="play-img" title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html"
                       target="_blank">
                        <img alt="${film.filmName}" src="${film.titleImg}">
                        <em>${film.codeValue}</em>
                    </a>
                    <b>
                        <a title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" target="_blank">
                             ${film.filmName}
                        </a>
                    </b>
                </li>
			</#list>
            </ul>
        </div>
        <div class="cr"></div>
        <div class="box">
            <div class="content">
                <div class="title">
                    <h2><a href="#" target="_blank">亚洲情色</a></h2>
                </div>
                    <ul class="img-list dis clearfix">
					 <#list (YZQS) as film>
                        <li>
                            <a class="play-img" title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html"
                               target="_blank">
                                <img alt=" ${film.filmName}" src="${film.titleImg}">
                                <em>${film.createDate?string("MM-dd")}</em>
                            </a>
                            <b>
                                <a title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" target="_blank">
                                     ${film.filmName}
                                </a>
                            </b>
                            <p>${film.clickAmount}</p>
                        </li>
					 </#list>
                    </ul>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">亚洲情色推荐榜</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list (yzqstj) as film>
                            <li>
                                <i class="n">${film_index+1}</i>
                                <a href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" title="${film.filmName}" target="_blank">${film.filmName}</a>
                            </li>
						</#list>
                        </ul>
                    </dlv>
                </div>
            </div>
        </div>
        <div class="box">
            <div class="content">
                <div class="title">
                    <h2><a href="#" target="_blank">制服丝袜</a></h2>
                </div>
                    <ul class="img-list dis clearfix">
					<#list (ZFSW) as film>
                          <li>
                            <a class="play-img" title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html"
                               target="_blank">
                                <img alt=" ${film.filmName}" src="${film.titleImg}">
                                <em>${film.createDate?string("MM-dd")}</em>
                            </a>
                            <b>
                                <a title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" target="_blank">
                                     ${film.filmName}
                                </a>
                            </b>
                            <p>${film.clickAmount}</p>
                        </li>
					</#list>
                    </ul>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">制服丝袜推荐榜</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list (zfswtj) as film>
                            <li>
                                <i class="n">${film_index+1}</i>
                                <a href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" title="${film.filmName}" target="_blank">${film.filmName}</a>
                            </li>
						</#list>
                        </ul>
                    </dlv>
                </div>
                <div class="cr"></div>
            </div>
        </div>
        <div class="box">
            <div class="content">
                <div class="title">
                    <h2><a href="#" target="_blank">欧美性爱</a></h2>
                </div>
                    <ul class="img-list dis clearfix">
					<#list (OMXA) as film>
                          <li>
                            <a class="play-img" title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html"
                               target="_blank">
                                <img alt=" ${film.filmName}" src="${film.titleImg}">
                                <em>${film.createDate?string("MM-dd")}</em>
                            </a>
                            <b>
                                <a title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" target="_blank">
                                     ${film.filmName}
                                </a>
                            </b>
                            <p>${film.clickAmount}</p>
                        </li>
					</#list>
                    </ul>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">欧美性爱推荐榜</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list (omxatj) as film>
                            <li>
                                <i class="n">${film_index+1}</i>
                                <a href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" title="${film.filmName}" target="_blank">${film.filmName}</a>
                            </li>
						</#list>
                        </ul>
                    </dlv>
                </div>
                <div class="cr"></div>
            </div>
        </div>
        <div class="box">
            <div class="content">
                <div class="title">
                    <h2><a href="#" target="_blank">网友自拍</a></h2>
                </div>
                    <ul class="img-list dis clearfix">
					<#list (WYZP) as film>
                          <li>
                            <a class="play-img" title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html"
                               target="_blank">
                                <img alt=" ${film.filmName}" src="${film.titleImg}">
                                <em>${film.createDate?string("MM-dd")}</em>
                            </a>
                            <b>
                                <a title="${film.filmName}" href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" target="_blank">
                                     ${film.filmName}
                                </a>
                            </b>
                            <p>${film.clickAmount}</p>
                        </li>
					</#list>
                    </ul>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">网友自拍推荐榜</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list (wyzptj) as film>
                            <li>
                                <i class="n">${film_index+1}</i>
                                <a href="/app/vod/${film.filmType}/${film.createDate?string("yyyy/MMdd")}/${(film.filmID)?c}.html" title="${film.filmName}" target="_blank">${film.filmName}</a>
                            </li>
						</#list>
                        </ul>
                    </dlv>
                </div>
                <div class="cr"></div>
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