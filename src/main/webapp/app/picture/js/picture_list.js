/**
 * Created by wenheng on 2017/12/17.
 */

var pageSize = 25;
var stNum = 194;
var startShow=25;

function $initPageList(count,type) {
    var i=0;
    var n=0;
    var loc = window.location.href;
    var totalNum = Math.ceil(count / pageSize);
    var pageNum = loc.substring(loc.lastIndexOf("/") + 1).replace(/[^0-9]/ig, "");
    $("#pages b").html("页次："+pageNum+"/"+totalNum+" 每页25 总数"+count);
    var url="/app/picture/"+type+"/index_";
    if (pageNum == 1) {
        $("#pages #a3").attr("href",url+(pageNum-0+1)+".html");
        $("#pages #a4").attr("href",url+(totalNum)+".html");
    } else if (pageNum == totalNum) {
        $("#pages #a2").attr("href",url+(pageNum-1)+".html");
    } else {
        $("#pages #a2").attr("href",url+(pageNum-1)+".html");
        $("#pages #a3").attr("href",url+(pageNum-0+1)+".html");
        $("#pages #a4").attr("href",url+(totalNum)+".html");
    }
    $(".art_box .art ul li").each(function () {
         if (i>=startShow && n<pageSize){
             $(this).attr("style","block");
             n++;
         }
        i++;
    });
}