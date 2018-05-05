<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${film.filmName}-老哥稳影院</title>
    <meta name="referrer" content="never">
    <meta name="keywords" content="老哥稳，老哥稳影院">
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
        <div class="view">
            <div class="wz">
                当前位置:
                <a href="/">首页</a> »
                <a href="#">制服丝袜</a> »
                <a href="#"></a>
            </div>
            <div class="pic">
                <img src="${film.titleImg}" alt="${film.filmName}">
                <p>
                    <a href="#kan">立即播放</a>
                </p>
            </div>
            <div class="info">
                <h1>${film.filmName}</h1>
                <ul>
                    <li>
                        <span>影片类型：</span>
                        <a href="" target="_blank" title="制服丝袜">${film.codeValue}</a>
                    </li>
                    <li>
                        <span>看片帮助：</span>
                        <a href="/help/help.html" target="_blank" title="制服丝袜">看片教程</a>
                    </li>
                    <li>
                        <span>移动端看片：</span>
                        <a href="/help/mobile.html" target="_blank" title="制服丝袜">看片教程</a>
                    </li>
                    <li>
                        <span>更新日期：</span>
                        <a href="" target="_blank" title="制服丝袜">${film.createDate?string("yyyy-MM-dd")}</a>
                    </li>
                    <li>
                        <span>最新网址：</span>
                        <a href="" target="_blank" title="制服丝袜">HTTPS://WWW.LAOGEWEN.CO</a>
                    </li>
                </ul>
                <div class="pfen">
                    <font color="#FF0000">撸友小提示：</font>
                    遇到本网站无法访问!请在网址前面加HTTPS://
                </div>
            </div>
            <div class="updatetps clearfix">

            </div>
        </div>
        <div class="infoad">
            <div class="skydrive">
                <p>
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cgw1f3hjze2unag200n00n08h.gif">
                          普通P2P下载
                     </span>
                </p>
                <ul>
                    <li class="thunder">
                        <a href="" target="_blank">&nbsp;迅雷下载</a>
                    </li>
                    <li class="qqdl">
                        <a href="" target="_blank">&nbsp;旋风下载</a>
                    </li>
                    <li class="flashget">
                        <a href="" target="_blank">&nbsp;快车下载</a>
                    </li>
                    <li class="ed2k">
                        <a href="" target="_blank">&nbsp;电驴下载</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="infoad">
            <div class="skydrive">
                <p>
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cgy1fgata3xmiug200n00n0g7.gif">
                          二维码
                     </span>
                </p>
                <ul>
                    <li>
                        <img id="qrCode" src="//pan.baidu.com/share/qrcode?w=248&h=248&url=laogewen.co">
                        <script>
                            document.getElementById("qrCode").src = "//pan.baidu.com/share/qrcode?w=248&h=248&url="+window.location.href;
                        </script>
                    </li>
                </ul>
            </div>
        </div>
        <div class="cr"></div>
        <div class="banner mt10"></div>
        <div class="endpage clearfix">
            <div class="ulike">
                <div class="title">
                    <span>猜您喜欢</span>
                </div>
                <ul class="img-list imglist clearfix">
                    <li>
                        <a class="play-img" href="#" target="_blank">
                            <img src="../img/593e241a388ae.jpg" alt="">
                        </a>
                        <h5>
                            <a href="" target="_blank" title="">最新一本道</a>
                        </h5>
                    </li>
                    <li>
                        <a class="play-img" href="#" target="_blank">
                            <img src="../img/593e24318c5ad.jpg" alt="">
                        </a>
                        <h5>
                            <a href="" target="_blank" title="">最新天然素人</a>
                        </h5>
                    </li>
                    <li>
                        <a class="play-img" href="#" target="_blank">
                            <img src="../img/593f6122eac9e.jpg" alt="">
                        </a>
                        <h5>
                            <a href="" target="_blank" title="">最新HEYZO</a>
                        </h5>
                    </li>
                    <li>
                        <a class="play-img" href="#" target="_blank">
                            <img src="../img/594228604c243.jpg" alt="">
                        </a>
                        <h5>
                            <a href="" target="_blank" title="">最新天然素人</a>
                        </h5>
                    </li>
                </ul>
            </div>
            <a id="kan"></a>
			<#if film.xfplay?? && film.xfplay!="" && film.xfplay!="null" >
            <div class="mox">
                <div class="title">
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cjw1f3hkd17ilhg200n00n741.gif">
                         先锋影音（边下边播模式，如果播放不流畅请下载完成后观看。）
                     </span>
                    <p>
                        <a href="http://www.xfplay.com" target="_blank" rel="nofollow">需要下载先锋影音播放器</a>
                    </p>
                </div>
                <div class="play-list">
                    <a href="/app/vod/play/xfplay.html?filmName=${film.filmName}&filmType=${film.filmType}&xfplay=${film.xfplay}" target="_blank">第1集</a>
                    <a href="/app/vod/play/xfplay.html?filmName=${film.filmName}&filmType=${film.filmType}&xfplay=${film.xfplay}">
                        第1集手机播放
                    </a>
                    <a href="" rel="nofollow" target="_blank">帮助</a>
                </div>
            </div>
			</#if>
            <div class="mox">
                <div class="title">
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cjw1f3hlz12tz6g200n00n741.gif">
                         迅雷影音（边下边播模式，如果播放不流畅请下载完成后观看。）
                     </span>
                    <p>
                        <a href="http://video.xunlei.com/" target="_blank" rel="nofollow">需要下载迅雷影音播放器</a>
                    </p>
                </div>
                <div class="play-list">
                    <a href="/app/help/help.html"
                       target="_blank">播放2331.8MB</a>
                    <a href="/app/help/help.html" rel="nofollow" target="_blank">帮助</a>
                </div>
            </div>
            <#if film.ed2k?? && film.ed2k!="" && film.ed2k!="null" >
            <div class="mox">
                <div class="title">
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cjw1f3hkjkfi7yg200n00n741.gif">
                         ed2k(电驴)链接（用于网盘离线下载）
                     </span>
                    <p>
                        <a href="http://www.xfplay.com" target="_blank" rel="nofollow">如果影音先锋不能播放请用ED2K链接!</a>
                    </p>
                </div>
                <div class="played2k">
                     <textarea rows="4" readonly="readonly" onclick="" autocomplete="on">${film.ed2k}</textarea>
                    <div class="play-list">
                        <a href="" target="_blank" rel="nofollow">手机看片方法</a>
                        <a href="" rel="nofollow" target="_blank">高速观影指南</a>
                    </div>
                </div>
            </div>
            </#if>
            <div class="mox">
                <a id="down"></a>
                <div class="title">
                     <span>
                         <img src="//wx1.sinaimg.cn/large/ab45ff5cgw1f3hjze2unag200n00n08h.gif">
                         普通P2P下载
                     </span>
                    <p>
                        非迅雷会员，请尽量使用QQ旋风下载，更加高速
                    </p>
                </div>
                <div class="downlist">
                    <ul>
                        <li>
                            <p></p>
                            <span>
                            <#if film.thunder?? && film.thunder!="" && film.thunder!="null" >
                             <a class="d1"
                                href="${film.thunder}"
                                target="_blank">
                                 迅雷下载
                             </a>
                            </#if>
                            <#if film.qqdl?? && film.qqdl!="" && film.qqdl!="null" >
                             <a class="d2"
                                href="${film.qqdl}"
                                target="_blank">
                                 旋风下载
                             </a>
                            </#if>
                            <#if film.flashGet?? && film.flashGet!="" && film.flashGet!="null" >
                             <a class="d3"
                                href="${film.flashGet}"
                                target="_blank">
                                 快车下载
                             </a>
                            </#if>
                             <#if film.ed2k?? && film.ed2k!="" && film.ed2k!="null" >
                             <a class="d4"
                                href="${film.ed2k}"
                                target="_blank">
                                 电驴下载
                             </a>
                            </#if>
                             </span>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="mox juqing">
                <a id="desc"></a>
                <div class="title">
                    <span></span>
                </div>
                <div class="endtext vodimg">
                    <p></p>
					<#list (film.img) as val>
                    <p><img src="${val}"></p>
					</#list>
                    <br/>
                    <p></p>
                    <br/>
                </div>
            </div>
            <div class="cr"></div>
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