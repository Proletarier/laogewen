<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>小说-老哥稳</title>
    <meta name="kryword" content="三五瓶，逼两拳，老哥还会军体拳">
    <meta name="referrer" content="never">
    <meta name="description" content="戒撸是不可能戒撸的，这辈子是不可能戒撸的，找小姐又不会，只有靠撸管才能维持的了生活。
    来老哥稳就像回家一样，里面个个都是人才，说话又好听，超喜欢在里面的。">
    <link href="/app/public/css/bootstrap.min.css" rel="stylesheet">
    <link href="/app/public/css/main.css" rel="stylesheet">
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
        <div class="pside">
            <ul class="nav nav-pills nav-stacked ">
                <li class="active"><a href="#">分类检索</a></li>
                <li><a href="/app/novel/JQWX/index_1.html">激情小说</a></li>
                <li><a href="/app/novel/LLWX/index_1.html">家庭乱伦</a></li>
                <li><a href="/app/novel/MXXY/index_1.html">明星校园</a></li>
                <li><a href="/app/novel/WXGD/index_1.html">武侠古典</a></li>
                <li><a href="/app/novel/HSXH/index_1.html">黄色笑话</a></li>
                <li><a href="/app/novel/XAJQ/index_1.html">性爱技巧</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="hotcon">
            <div class="htitle">
                <h3>老哥稳小说排行</h3>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/novel/JQWX/index_1.html">激情小说</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (JQWX) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>
				</ul>
                <p class="more"><a href="/app/novel/JQWX/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/novel/LLWX/index_1.html">家庭乱伦</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (LLWX) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>  
				 </ul>
                <p class="more"><a href="/app/novel/LLWX/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/novel/MXXY/index_1.html">明星校园</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (MXXY) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>
				 </ul>
                <p class="more"><a href="/app/novel/MXXY/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/novel/WXGD/index_1.html">武侠古典</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
        		  <#list (WXGD) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>
                </ul>
                <p class="more"><a href="/app/novel/WXGD/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
			<div class="hotbox">
                <div class="title">
                    <a href="/app/novel/HSXH/index_1.html">黄色笑话</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (HSXH) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>
                </ul>
                <p class="more"><a href="/app/novel/HSXH/index_1.html">查看更多&gt;&gt;</a></p>
            </div>
            <div class="hotbox">
                <div class="title">
                    <a href="/app/novel/XAJQ/index_1.html">性爱技巧</a>
                </div>
                <p class="bti">
                    <s>排名</s><em>名称</em><i>时间</i>
                </p>
                <ul>
				 <#list (XAJQ) as val>
                    <li><span>${val.createDate?string("MM-dd")}</span><i class="on">${val_index+1}</i><a href="/app/novel/${val.typeCode}/${val.createDate?string("yyyy/MMdd")}/${val.novelId}.html" target="_blank">${val.title}<</a></li>
                 </#list>
                </ul>
                <p class="more"><a href="/app/novel/XAJQ/index_1.html">查看更多&gt;&gt;</a></p>
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