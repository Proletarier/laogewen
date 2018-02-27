<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图库-老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="referrer" content="never">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/main/css/main.css" rel="stylesheet">
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
        <div class="pside">
            <ul class="nav nav-pills nav-stacked ">
                <li class="active"><a href="#">分类检索</a></li>
                <li><a href="/app/vod/TPZP/index_1.html">偷拍自拍</a></li>
                <li><a href="/app/vod/YZST/index_1.html">亚洲色图</a></li>
                <li><a href="/app/vod/SWMT/index_1.html">丝袜美腿</a></li>
                <li><a href="/app/vod/OMXA/index_1.html">欧美性爱</a></li>
                <li><a href="/app/vod/QJMX/index_1.html">激情明星</a></li>
                <li><a href="/app/vod/QCWM/index_1.html">清纯唯美</a></li>
                <li><a href="/app/vod/CRDM/index_1.html">成人动漫</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="hotcon">
            <div class="htitle">
                <h3>老哥稳图片排行</h3>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/TPZP/index_1.html">偷拍自拍</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				  <#list (TPZP) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                  </#list>
				</ul>
                <p class="more"><a href="/app/vod/TPZP/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/YZST/index_1.html">亚洲色图</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				  <#list (YZST) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                  </#list>
				</ul>
                <p class="more"><a href="/app/vod/YZST/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/SWMT/index_1.html">丝袜美腿</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (SWMT) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                 </#list>
			   </ul>
                <p class="more"><a href="/app/vod/SWMT/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/OMXA/index_1.html">欧美性爱</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (OMXA) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                 </#list>
			   </ul>
                <p class="more"><a href="/app/vod/OMXA/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/QJMX/index_1.html">激情明星</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				<#list (QJMX) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                </#list>
			   </ul>
                <p class="more"><a href="/app/vod/QJMX/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/QCWM/index_1.html">清纯唯美</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (QCWM) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                 </#list>
			   </ul>
                <p class="more"><a href="/app/vod/QCWM/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/vod/CRDM/index_1.html">成人动漫</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				  <#list (CRDM) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/picture/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${(val.pictureId)?c}.html" target="_blank">${val.name}</a></li>
                  </#list>
				</ul>
                <p class="more"><a href="/app/vod/CRDM/index_1.html">查看更多&gt;&gt;</a></p>
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