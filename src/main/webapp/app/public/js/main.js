/**
 * Created by wenheng on 2017/6/16.
 */

$(document).ready(function () {

    $("#search li").click(function () {
        var val = $(this).val();
        if (val == '1') {
            $("span.type").html("电影");
        } else if (val == '2') {
            $("span.type").html("图片");
        } else if (val == '3') {
            $("span.type").html('小说');
        }
    });


});


var filmTypeMap={
    YZQS:'亚洲情色',
    ZFSW:'制服丝袜',
    OMXA:'欧美性爱',
    WYZP:'网友自拍',
    JDSJ:'经典三级',
    LLND:'乱伦虐待',
    CRDM:'成人动漫',
    LLBT:'另类变态'
};

