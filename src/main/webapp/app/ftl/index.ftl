<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <title>小撸怡情，大撸伤身，强撸灰飞烟灭</title>
    <meta name="referrer" content="never">
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="app/public/css/main.css" rel="stylesheet">
    <script src="app/public/js/jquery-1.12.0.min.js"></script>
    <script src="app/public/js/bootstrap.min.js"></script>
    <script src="app/public/js/main.js"></script>
</head>
<body>
<div class="container" id="header">
    <div class="head">
        <script>
            $(".head").load("app/public/head.html");
        </script>       
    </div>
    <!-- 广告位 -->
    <div class="banner"></div>
    <div class="clear"></div>
    <div class="newnav">
        <script>
            $(".newnav").load("app/public/menu.html");
        </script>      
    </div>
    <div class="banner">
    </div>
    <div class="main">
        <div class="box newbox indexbox">
            <div class="shot update">
                <div class="title">
                    <h3>今日更新${GXSL}部</h3>
                    <span>
                        <a href="#" target="_blank">最近更新>></a>
                    </span>
                </div>
                <ul>
                <#if JRGX??>
                    <#list  JRGX as val>
                        <li>
                            <i class="n">${val_index+1}</i>
                            <a href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html" title="${val.filmName}"
                               target="_blank">
                                <#if val.filmName?length gt 15>
                              ${val.filmName?substring(0,15)}  
                            <#else>${val.filmName!}
                                </#if>
                            </a>
                            <span>
                            <font color="red">${val.createDate?string("MM-dd")}</font>
                            </span>
                        </li>
                    </#list>
                </#if>
                </ul>
            </div>
            <div class="content">
                <div class="title">
                    <h2>本周热播</h2>
                </div>
                <div class="bd clearfix">
                    <ul class="img-list dis clearfix">
                    <#list BZRB as val>
                        <li>
                            <a class="play-img" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                               title="${val.filmName}" target="_blank">
                                <img alt="${val.filmName}" src="${val.titleImg}"/>
                                <em>${val.codeValue}</em>
                            </a>
                            <b>
                                <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                                   target="_blank">
                                    <#if val.filmName?length gt 9>
                                      ${val.filmName?substring(0,9)}  
                                   <#else>${val.filmName!}
                                    </#if>
                                </a>
                            </b>
                            <p>${val.createDate?string("MM-dd")}</p>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
        </div>
        <div class="banner mt10"></div>
        <div class="trailers mt10">
            <div class="title">
                <b>
                    <a style="color: #06a6e2" href="#" target="_blank">猜您喜欢</a>
                </b>
                全部<i>${count}</i>部>>
            </div>
            <ul class="img-list">
            <#list CNXH as val>
                <li>
                    <a class="play-img" title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                       target="_blank">
                        <img alt="${val.filmName}" src="${val.titleImg}">
                        <em>${val.codeValue}</em>
                    </a>
                    <b>
                        <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html" target="_blank">
                            <#if val.filmName?length gt 9>
                               ${val.filmName?substring(0,9)}
                             <#else>${val.filmName!}
                            </#if>
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
                    <h2><a href="#" target="_blank">在线视频</a></h2>
                </div>
                <div class="bd clearfix">
                    <ul class="txt-list">
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e585875ea7e.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新heyzo0908君岛ア</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2018-01-16/5a5cf09189660.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新heyzo0920若松玲</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e58583c2905.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新heyzo0889大空美</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5857f8c54e.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新heyzo0894荒木ま</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5857b9016a.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新一本道:音羽レオ</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e585792ef93.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新heyzo0888百田ま</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5854304217.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">妖艶なる我が家のMAI</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e58577dead4.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新东京热Tokyo-H</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e585787eae0.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新加勒比061615-</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5857886c07.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新东京热Tokyo-H</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5857899b74.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">最新加勒比062415-</a>
                            </p>
                        </li>
                        <li>
                            <a title="" href="#" target="_blank">
                                <img class="img-rounded" src="//i3.1100lu.xyz/vod/2016-03-13/56e5857899b74.jpg" alt="">
                            </a>
                            <p>
                                <a title="" href="" target="_blank">野外で室内で激しく贫</a>
                            </p>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">最新小説</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list (novels) as val>
                            <li>
                                <i class="n">${val_index+1}</i>
                                <a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" title="${val.title}" target="_blank">${val.title}</a>
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
                    <h2><a href="#" target="_blank">最新亚洲性爱</a></h2>
                </div>
                <div class="bd clearfix">
                    <ul class="txt-list">
                    <#list YZQS as val>
                        <li>
                            <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                               target="_blank">
                                <img class="img-rounded" src="${val.titleImg}" alt="${val.filmName}">
                            </a>
                            <p>
                                <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                                   target="_blank">
                                    <#if val.filmName?length gt 9>
                               ${val.filmName?substring(0,9)}
                             <#else>${val.filmName!}
                                    </#if>
                                </a>
                            </p>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">最新亚洲色图</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
						<#list YZST as val>
                            <li>
                                <i class="n">${val_index+1}</i>
                                <a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" title="${val.name}" target="_blank">${val.name}</a>
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
                    <h2><a href="#" target="_blank">最新制服丝袜</a></h2>
                </div>
                <div class="bd clearfix">
                    <ul class="txt-list">
                    <#list ZFSW as val>
                        <li>
                            <a title=${val.filmName}"" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                               target="_blank">
                                <img class="img-rounded" src="${val.titleImg}" alt="${val.filmName}">
                            </a>
                            <p>
                                <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                                   target="_blank">
                                    <#if val.filmName?length gt 9>
                               ${val.filmName?substring(0,9)}
                             <#else>${val.filmName!}
                                    </#if>
                                </a>
                            </p>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">最新丝袜美腿</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
 					    <#list SWMT as val>
                            <li>
                                <i class="n">${val_index+1}</i>
                                <a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" title="${val.name}" target="_blank">${val.name}</a>
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
                    <h2><a href="#" target="_blank">最新欧美性爱</a></h2>
                </div>
                <div class="bd clearfix">
                    <ul class="txt-list">
                    <#list OMXA as val>
                        <li>
                            <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                               target="_blank">
                                <img class="img-rounded" src="${val.titleImg}" alt="${val.filmName}">
                            </a>
                            <p>
                                <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                                   target="_blank">
                                    <#if val.filmName?length gt 9>
                               ${val.filmName?substring(0,9)}
                             <#else>${val.filmName!}
                                    </#if>
                                </a>
                            </p>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">最新欧美色图</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
					    <#list OMST as val>
                            <li>
                                <i class="n">${val_index+1}</i>
                                <a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" title="${val.name}" target="_blank">${val.name}</a>
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
                    <h2><a href="#" target="_blank">最新网友自拍</a></h2>
                </div>
                <div class="bd clearfix">
                    <ul class="txt-list">
                    <#list WYZP as val>
                        <li>
                            <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                               target="_blank">
                                <img class="img-rounded" src="${val.titleImg}" alt="${val.filmName}">
                            </a>
                            <p>
                                <a title="${val.filmName}" href="/app/vod/${val.filmType}/${val.createDate?string("yyyy/MMdd")}/${(val.filmId)?c}.html"
                                   target="_blank">
                                    <#if val.filmName?length gt 9>
                               ${val.filmName?substring(0,9)}
                             <#else>${val.filmName!}
                                    </#if>
                                </a>
                            </p>
                        </li>
                    </#list>
                    </ul>
                </div>
            </div>
            <div class="side">
                <div class="shot">
                    <dl>
                        <dt>
                            <a href="" target="_blank">最新自拍色图</a>
                        </dt>
                    </dl>
                    <dlv class="bd">
                        <ul class="dis">
 					    <#list ZPST as val>
                            <li>
                                <i class="n">${val_index+1}</i>
                                <a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" title="${val.name}" target="_blank">${val.name}</a>
                            </li>
						</#list>
                        </ul>
                    </dlv>
                </div>
                <div class="cr"></div>
            </div>
        </div>
        <div class="link">
            <div class="title">
                <span>合作伙伴</span>
                <p></p>
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