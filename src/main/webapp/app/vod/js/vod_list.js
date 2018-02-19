/**
 * Created by wenheng on 2017/8/14.
 */

var page='<li><a href="#" onclick=""></a></li>';
var totalSize=5;
var startShow= 14;
var pageSize = 14;

function $initPage(size,total,type) {
    var obj="";
    var startNum=$getPage(size,total);
    if(size>1){
        obj='<li><a href="/app/vod/'+type+'/index_'+(size*1-1)+'.html">上一页</a></li>';
    }
    for(var i=0;i<totalSize;i++){
        if(size==startNum){
            obj+='<li class="active"><a>'+startNum+'</a></li>';
            startNum++;
            continue
        }
        obj+='<li><a href="/app/vod/'+type+'/index_'+startNum+'.html">'+startNum+'</a></li>';
        startNum++;
    }
    if(size<total){
        obj+='<li><a href="/app/vod/'+type+'/index_'+(size*1+1)+'.html">下一页</a></li>';
    }
    return obj;
}
function  $getPage(size,total) {


    var startNum;
    if(size<Math.ceil(totalSize/2))
        startNum=1;
    else if(total-size<=Math.ceil(totalSize/2))
        startNum=total-totalSize+1;
    else
        startNum=size-(Math.floor(totalSize/2));

    return startNum;
}

function $initPageList() {
    var i=0;
    var n=0;
    $(".pagelist .movielist ul li").each(function () {
        if (i>=startShow && n<pageSize){
            $(this).attr("style","block");
            n++;
        }
        i++;
    });
}